package com.openmrs.qa.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import com.openmrs.qa.pages.LoginPage;
import com.openmrs.qa.utilities.ConfigReader;
import com.openmrs.qa.utilities.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("I launch the OpenMRS application")
    public void i_launch_the_open_mrs_application() {
        // Dynamic: Gets URL from config.properties
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        System.out.println("Navigated to: " + url);
    }

    @Then("I should see the Login Page title {string}")
    public void i_should_see_the_login_page_title(String expectedTitle) {
        // Best Practice: Explicit Wait
        // Wait up to 10 seconds for the title to actually contain the expected text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(expectedTitle));

        // Now assert the value (it is guaranteed to be loaded)
        String actualTitle = driver.getTitle();
        Assert.assertNotNull(actualTitle, "Page title is null!");
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title did not match!");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        // Dynamic: Uses Page Object Model - no hardcoding
        loginPage.enterUsername(username);
    }


    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        // Dynamic: Uses Page Object Model - no hardcoding
        loginPage.enterPassword(password);
    }


    @And("I click the login button")
    public void iClickTheLoginButton() {
        // Dynamic: Uses Page Object Model - handles location selection automatically
        loginPage.clickLoginButton();
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedErrorMessage) {
        // 1. Increase wait to 20 seconds for the public demo server
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // 2. Use '.' instead of 'text()' -> This finds the text even if it's nested in <span> or <b> tags
        // We only search for the first word "Invalid" to keep the locator simple and robust
        By errorLocator = By.xpath("//*[contains(., 'Invalid')]");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        } catch (Exception e) {
            // This helps us see in the logs if it failed specifically here
            throw new AssertionError("Error message not visible after 20 seconds", e);
        }

        // 3. Verify the full text matches what we expect
        String actualText = driver.findElement(errorLocator).getText();
        Assert.assertTrue(actualText.contains(expectedErrorMessage),
                "Expected error to contain: '" + expectedErrorMessage + "', but found: '" + actualText + "'");
    }
}