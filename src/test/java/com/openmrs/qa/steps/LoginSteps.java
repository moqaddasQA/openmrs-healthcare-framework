package com.openmrs.qa.steps;

import com.openmrs.qa.pages.LoginPage;
import com.openmrs.qa.utilities.ConfigReader;
import com.openmrs.qa.utilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("I launch the OpenMRS application")
    public void i_launch_the_open_mrs_application() {
        // FIXED: Explicitly tell the driver to go to the URL
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        System.out.println("Navigated to: " + url);
    }

    @Then("I should see the Login Page title {string}")
    public void i_should_see_the_login_page_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println("Verifying Title. Expected: '" + expectedTitle + "', Found: '" + actualTitle + "'");

        // Assertion
        if (actualTitle != null) {
            Assert.assertTrue(actualTitle.contains(expectedTitle),
                    "Page title did not match! Expected to contain: " + expectedTitle + " but found: " + actualTitle);
        }
    }
}