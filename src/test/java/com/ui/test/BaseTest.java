package com.ui.test;

import com.ui.driverutils.DriverManager;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

@Log4j2
public class BaseTest {


    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser){
        log.info("Launching Browser instance for: " + browser);
        try {
            DriverManager.setUpDriver(browser, "local");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
