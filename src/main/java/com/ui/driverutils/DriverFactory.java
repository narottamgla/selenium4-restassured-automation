package com.ui.driverutils;

import com.ui.executiondata.ExecutionConf;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Log4j2
public class DriverFactory {

    public  WebDriver getDriver() {


        if(ExecutionConf.EXECUTION_MODE.equalsIgnoreCase("local")) {
            return getLocalDriver();
        } else {
            return getRemoteDriver();
        }
    }

    private WebDriver getRemoteDriver() {
        return null;
    }

    private WebDriver getLocalDriver() {
        return getDriver(ExecutionConf.BROWSER);
    }

    private WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return getChromeDiver();
            case "firefox":
                return getFirefoxDriver();
            case "ie":
                return getIEDriver();
            case "edge":
                return getEdgeDriver();
            case "opera":
                return getOperaDriver();
            case "phantomjs":
                return getPhantomJSDriver();
            default:
                return getChromeDiver();
        }
    }

    private WebDriver getChromeDiver() {
        log.info("Creating new Chrome browser instance");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        return driver;
    }

    public WebDriver getFirefoxDriver() {
        log.info("Creating new Firefox driver instance");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        return driver;
    }

    public WebDriver getIEDriver() {
        return null;
    }

    public WebDriver getEdgeDriver() {
        return null;
    }

    public WebDriver getOperaDriver() {
        return null;
    }

    public WebDriver getPhantomJSDriver() {
        return null;
    }

}
