package com.openmrs.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginPage extends BasePage {

    // --- Locators ---
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");

    // Locators for Location and Button
    private final By allLocations = By.cssSelector("ul#sessionLocation li");
    private final By loginButton = By.xpath("//input[@type='submit' or @id='loginButton']"); // More robust locator
    private final By errorJson = By.id("error-message");

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
        return getText(errorJson);
    }

    private void pickFirstLocation() {
        try {
            List<WebElement> locations = driver.findElements(allLocations);

            if (!locations.isEmpty()) {
                WebElement firstLocation = locations.get(0);
                logger.info("Location tiles found. Picking: {}", firstLocation.getText());

                // Use JS click to ensure it works
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", firstLocation);
            } else {
                logger.warn("No location tiles found. Proceeding to login without selecting a location.");
            }
        } catch (Exception e) {
            logger.warn("Error while checking for locations. Skipping step.");
        }
    }
}