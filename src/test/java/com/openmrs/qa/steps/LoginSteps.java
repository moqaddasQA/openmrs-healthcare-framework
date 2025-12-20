package com.openmrs.qa.steps;

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
        // Dynamic: Gets error message from page using Page Object Model
        String actualErrorMessage = loginPage.getErrorMessage();
        System.out.println("Expected Error: '" + expectedErrorMessage + "', Actual Error: '" + actualErrorMessage + "'");

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Error message did not match! Expected: " + expectedErrorMessage + " but found: " + actualErrorMessage);
    }
}