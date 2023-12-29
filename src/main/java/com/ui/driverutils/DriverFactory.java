package com.ui.driverutils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static WebDriver createDriver(String browser, String environment) throws MalformedURLException {
        WebDriver driver;

        if ("local".equalsIgnoreCase(environment)) {
            driver = createLocalDriver(browser);
        } else if ("saucelabs".equalsIgnoreCase(environment)) {
            driver = createSauceLabsDriver(browser);
        } else {
            throw new IllegalArgumentException("Invalid environment: " + environment);
        }

        return driver;
    }

    private static WebDriver createLocalDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = createChromeDriver();
                break;
            case "firefox":
                driver = createFirefoxDriver();
                break;
            // Add more cases for other browsers if needed

            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        return driver;
    }

    private static WebDriver createSauceLabsDriver(String browser) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        // Add Sauce Labs specific capabilities as needed

        MutableCapabilities capabilities;

        switch (browser.toLowerCase()) {
            case "chrome":
                capabilities = new MutableCapabilities();
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("sauce:options", sauceOptions);
                break;
            case "firefox":
                capabilities = new MutableCapabilities();
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("sauce:options", sauceOptions);
                break;
            // Add more cases for other browsers if needed

            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        return new RemoteWebDriver(new URL("https://your-saucelabs-url.com/wd/hub"), capabilities);
    }

    private static WebDriver createChromeDriver() {
        // Use WebDriverManager to set up ChromeDriver for local execution
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        // Use WebDriverManager to set up FirefoxDriver for local execution
        return new FirefoxDriver();
    }
}
