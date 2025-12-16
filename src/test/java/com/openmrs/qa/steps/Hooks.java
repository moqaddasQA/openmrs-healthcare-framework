package com.openmrs.qa.steps;

import com.openmrs.qa.utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() {
        // Optional: Any setup before EACH scenario
        // Driver is initialized lazily in the Steps, but you could do it here too.
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed()) {
            // Take Screenshot on Failure
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screen");
        }

        // Close the driver after EACH scenario to ensure a clean slate for the next one
        DriverFactory.closeDriver();
    }
}