package com.ui.driverutils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DriverManager {

    WebDriver driver;

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();


    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (webDriver.get() == null) {
            log.info("Creating New Driver Instance");
            webDriver.set(new DriverFactory().getDriver());
        }
        log.info("Returning Existing driver instance");
        return new DriverManager();

    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public void quitDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    public void closeDriver() {
        webDriver.get().close();
        webDriver.remove();
    }

}