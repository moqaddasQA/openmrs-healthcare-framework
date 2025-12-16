package com.openmrs.qa.base;

import com.openmrs.qa.utilities.ConfigReader;
import com.openmrs.qa.utilities.DriverFactory;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Base Test Class for all test classes
 * Provides common setup, teardown, and utility methods
 */
public abstract class BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetup() {
        logger.info("=== Test Suite Started ===");
        logger.info("Test Environment: {}", ConfigReader.getProperty("test.environment"));
        logger.info("Browser: {}", ConfigReader.getProperty("browser"));
        logger.info("Headless Mode: {}", ConfigReader.getProperty("headless"));
    }

    @BeforeClass(alwaysRun = true)
    public void classSetup() {
        logger.info("=== Test Class Started: {} ===", this.getClass().getSimpleName());
    }

    @BeforeMethod(alwaysRun = true)
    public void methodSetup(Method method) {
        logger.info("=== Test Method Started: {} ===", method.getName());
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void methodTeardown(ITestResult result, Method method) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test FAILED: {}", method.getName());
            captureScreenshotOnFailure(result);
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Test SKIPPED: {}", method.getName());
        } else {
            logger.info("Test PASSED: {}", method.getName());
        }

        // Don't close driver here - let it be reused for parallel tests
    }

    @AfterClass(alwaysRun = true)
    public void classTeardown() {
        logger.info("=== Test Class Completed: {} ===", this.getClass().getSimpleName());
    }

    @AfterSuite(alwaysRun = true)
    public void suiteTeardown() {
        logger.info("=== Closing all drivers ===");
        DriverFactory.closeDriver();
        logger.info("=== Test Suite Completed ===");
    }

    /**
     * Capture screenshot on test failure
     *
     * @param result TestResult object
     */
    @Step("Capture screenshot on failure")
    private void captureScreenshotOnFailure(ITestResult result) {
        if (ConfigReader.getPropertyAsBoolean("take.screenshot.on.failure")) {
            try {
                if (driver != null) {
                    String screenshotName = result.getMethod().getMethodName() + "_" + System.currentTimeMillis();
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    attachScreenshotToAllure(screenshotName, screenshot);
                    logger.info("Screenshot captured for failed test: {}", screenshotName);
                }
            } catch (Exception e) {
                logger.error("Failed to capture screenshot", e);
            }
        }
    }

    /**
     * Attach screenshot to Allure report
     *
     * @param name       Screenshot name
     * @param screenshot Screenshot as byte array
     */
    @Attachment(value = "Screenshot: {0}", type = "image/png")
    private byte[] attachScreenshotToAllure(String name, byte[] screenshot) {
        return screenshot;
    }

    /**
     * Navigate to URL
     *
     * @param url URL to navigate to
     */
    @Step("Navigate to URL: {0}")
    protected void navigateTo(String url) {
        logger.info("Navigating to URL: {}", url);
        driver.get(url);
    }

    /**
     * Navigate to base application URL
     */
    @Step("Navigate to application")
    protected void navigateToApplication() {
        String url = ConfigReader.getProperty("url");
        navigateTo(url);
    }

    /**
     * Wait for specified seconds
     *
     * @param seconds Number of seconds to wait
     */
    @Step("Wait for {0} seconds")
    protected void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
            logger.debug("Waited for {} seconds", seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Wait interrupted", e);
        }
    }

    /**
     * Get current page title
     *
     * @return Page title
     */
    protected String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get current URL
     *
     * @return Current URL
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}