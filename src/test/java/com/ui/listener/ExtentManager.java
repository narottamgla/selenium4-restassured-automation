package com.ui.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.ui.driverutils.DriverManager;

import java.io.File;
import java.util.Date;


@Log4j2
public class ExtentManager {

    private static ExtentReports extentReports;
    public static String reportFilePath = "";

    public static ExtentReports createInstance(String fileName) {
        reportFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "reports" + File.separator;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFilePath + fileName);
        log.info("Report being written to: " + reportFilePath);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setReportName("Selenium Automation");
        htmlReporter.config().setTimelineEnabled(true);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
        return extentReports;
    }

    public static String screenshotPath;
    public static String screenshotName;

    public static void captureScreenshot() {

        File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        try {
            	FileUtils.copyFile(scrFile, new File(reportFilePath + screenshotName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
