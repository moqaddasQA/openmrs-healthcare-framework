package com.openmrs.qa.steps;

import com.openmrs.qa.utilities.DriverFactory; // Or wherever your Driver is initialized
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        // Only take a screenshot if the scenario FAILED
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getDriver();
            if (driver != null) {
                // 1. Take the screenshot as a byte array
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // 2. Attach it to the Allure Report
                Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshot));
            }
        }

        // Optional: Quit driver here if you aren't doing it elsewhere
        DriverFactory.closeDriver();
    }
}