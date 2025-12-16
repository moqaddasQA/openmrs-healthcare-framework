package com.openmrs.qa.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private DriverFactory() { }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            // Get browser type from config (default to chrome)
            String browserType = ConfigReader.getProperty("browser", "chrome").toLowerCase();
            boolean isHeadless = ConfigReader.getPropertyAsBoolean("headless", false);

            logger.info("Initializing {} driver (headless: {})", browserType, isHeadless);

            // SELENIUM 4.27+ NATIVE MANAGER (No WebDriverManager needed!)
            switch (browserType) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    if (isHeadless) options.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(options));
                }
                case "firefox" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    if (isHeadless) options.addArguments("-headless");
                    driverPool.set(new FirefoxDriver(options));
                }
                case "edge" -> {
                    EdgeOptions options = new EdgeOptions();
                    if (isHeadless) options.addArguments("--headless");
                    driverPool.set(new EdgeDriver(options));
                }
                default -> throw new RuntimeException("Invalid browser: " + browserType);
            }

            // Common Setup
            WebDriver driver = driverPool.get();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(ConfigReader.getPropertyAsInt("implicit.wait", 10))
            );
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}