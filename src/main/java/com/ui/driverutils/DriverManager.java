package com.ui.driverutils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverManager {

    private String executionBrowser;
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void setDriver(String browser, String environment) throws MalformedURLException {
        WebDriver driver = DriverFactory.createDriver(browser, environment);
        webDriverThreadLocal.set(driver);
    }

    public static void quitDriver() {
        if (webDriverThreadLocal.get() != null) {
            webDriverThreadLocal.get().quit();
            webDriverThreadLocal.remove();
        }
    }

    public static void setUpDriver(String browser, String environment) throws MalformedURLException {
        if ("local".equalsIgnoreCase(environment)) {
            setUpLocalDriver(browser);
        } else if ("saucelabs".equalsIgnoreCase(environment)) {
            setUpSauceLabsDriver(browser);
        } else {
            throw new IllegalArgumentException("Invalid environment: " + environment);
        }
    }

    private static void setUpLocalDriver(String browser) {
        //WebDriverManager.chromedriver().setup();
      //  WebDriverManager.firefoxdriver().setup();

        try {
            setDriver(browser, "local");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setUpSauceLabsDriver(String browser) throws MalformedURLException {
        setDriver(browser, "saucelabs");
    }

    public static void tearDownDriver() {
        quitDriver();
    }
}
