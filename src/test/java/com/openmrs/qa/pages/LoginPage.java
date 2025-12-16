package com.openmrs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    // Helper method to check if element is present without throwing exception
    private boolean isElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
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
            // FIX: Explicitly wait up to 10 seconds for the location tiles to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(allLocations));

            List<WebElement> locations = driver.findElements(allLocations);

            if (!locations.isEmpty()) {
                WebElement firstLocation = locations.getFirst(); // Uses Java 21 syntax
                logger.info("Location tiles found. Picking: {}", firstLocation.getText());

                // Use JS click to ensure it works reliably
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", firstLocation);
            } else {
                logger.warn("No location tiles found. Proceeding to login without selecting a location.");
            }
        } catch (Exception e) {
            logger.error("Error while checking for locations: ", e);
        }
    }
}