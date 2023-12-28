package com.ui.test;

import com.ui.driverutils.DriverManager;
import com.ui.executiondata.ExecutionConf;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@Log4j2
public class BaseTest {


    @BeforeMethod
    @Parameters("browser")
    public void setup(){
        log.info("Launching Browser instance for: " + System.getProperty("browser"));
        DriverManager.getInstance().getDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.getInstance().closeDriver();
        DriverManager.getInstance().quitDriver();

    }
}
