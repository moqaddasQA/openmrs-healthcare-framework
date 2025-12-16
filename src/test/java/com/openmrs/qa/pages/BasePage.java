package com.openmrs.qa.pages;

import com.openmrs.qa.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Abstract BasePage - The Parent of all Page Objects.
 * Implements OOP (Inheritance) to share common behavior like waiting, clicking, and typing.
 * Uses ConfigReader for dynamic timeouts and SLF4J for consistent logging.
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Constructor (Dependency Injection of Driver)
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Dynamically fetch the wait time from config.properties
        int waitTime = ConfigReader.getPropertyAsInt("explicit.wait", 10);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

    /**
     * Generic Click Method with Dynamic Wait & Logging
     * Encapsulation: Hides the complexity of waiting from the Test Class.
     */
    protected void click(By locator) {
        try {
            logger.info("Attempting to click element: {}", locator);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            logger.info("Successfully clicked element: {}", locator);
        } catch (Exception e) {
            logger.error("Failed to click element: {}", locator, e);
            throw e; // Rethrow to fail the test properly
        }
    }

    /**
     * Generic Type/SendKeys Method with Dynamic Wait
     */
    protected void enterText(By locator, String text) {
        try {
            logger.info("Attempting to enter text into: {}", locator);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            logger.info("Entered text '{}' into element: {}", text, locator);
        } catch (Exception e) {
            logger.error("Failed to enter text into: {}", locator, e);
            throw e;
        }
    }

    /**
     * Generic Get Text Method with Visibility Check
     */
    protected String getText(By locator) {
        try {
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
            logger.debug("Retrieved text '{}' from element: {}", text, locator);
            return text;
        } catch (Exception e) {
            logger.error("Failed to get text from: {}", locator, e);
            throw e;
        }
    }

    /**
     * Generic method to check if element is displayed
     */
    protected boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            logger.warn("Element not displayed: {}", locator);
            return false;
        }
    }
}