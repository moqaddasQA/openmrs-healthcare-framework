package com.openmrs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {

    // --- Locators ---
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");

    // Locators for Location and Button
    private final By allLocations = By.cssSelector("ul#sessionLocation li");
    private final By loginButton = By.xpath("//input[@type='submit' or @id='loginButton']");

    // FIXED: Updated error message locator - OpenMRS uses a paragraph tag with specific ID
    private final By errorMessage = By.id("error-message");
    // Backup locators in case the primary one doesn't work
    private final By errorMessageAlt1 = By.xpath("//p[contains(@class, 'error')]");
    private final By errorMessageAlt2 = By.xpath("//*[contains(text(), 'Invalid') or contains(text(), 'invalid')]");

    // --- Constructor ---
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // --- Actions ---
    public void login(String username, String password) {
        logger.info("Logging in with username: {}", username);
        enterText(usernameField, username);
        enterText(passwordField, password);

        // CONDITIONAL: Only pick a location if the tiles actually exist
        pickFirstLocation();

        click(loginButton);
    }

    public String getErrorMessage() {
        logger.info("Attempting to retrieve error message");

        // Try multiple locators to find the error message
        try {
            // Try primary locator
            if (isElementPresent(errorMessage)) {
                return getText(errorMessage);
            }
        } catch (Exception e) {
            logger.warn("Primary error locator failed: {}", e.getMessage());
        }

        try {
            // Try alternative locator 1
            if (isElementPresent(errorMessageAlt1)) {
                return getText(errorMessageAlt1);
            }
        } catch (Exception e) {
            logger.warn("Alternative error locator 1 failed: {}", e.getMessage());
        }

        try {
            // Try alternative locator 2
            if (isElementPresent(errorMessageAlt2)) {
                return getText(errorMessageAlt2);
            }
        } catch (Exception e) {
            logger.warn("Alternative error locator 2 failed: {}", e.getMessage());
        }

        logger.error("No error message found with any locator");
        return ""; // Return empty string if no error found
    }

    private boolean isElementPresent(By locator) {
        try {
            // 1. Set wait to 0 to check instantly
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

            // 2. Use a short 2-second Explicit wait for the check
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            return true;
        } catch (Exception e) {
            return false;
        } finally {
            // 3. ALWAYS set it back to your global 10 or 20 seconds
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void enterUsername(String username) {
        logger.info("Entering username: {}", username);
        enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password: {}", password);
        enterText(passwordField, password);
    }

    public void clickLoginButton() {
        logger.info("Clicking login button");
        pickFirstLocation();
        click(loginButton);
    }

    private void pickFirstLocation() {
        try {
            // Quick check: Are there any locations on the screen right now?
            List<WebElement> quickCheck = driver.findElements(allLocations);

            if (quickCheck.isEmpty()) {
                logger.info("No locations visible immediately. Skipping wait to save time.");
                return;
            }

            // If they are present, wait a short moment to ensure they are clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(allLocations));

            quickCheck.getFirst().click();
            logger.info("Location selected: {}", quickCheck.getFirst().getText());

        } catch (Exception e) {
            logger.debug("Location selection skipped or timed out - this is normal for invalid login tests.");
        }
    }
}