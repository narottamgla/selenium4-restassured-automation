package com.ui.action;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ui.driverutils.DriverManager;
import com.ui.listener.ExtentListeners;
import com.ui.listener.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions {

    WebDriver driver;
    public PageActions() {
        this.driver = DriverManager.getInstance().getDriver();
    }

    public void click(WebElement element, String elementName) {
        try {
            element.click();
            logInfo("Clicking on : " + elementName);
        } catch (Exception e) {
            logError("Can't Click on : " + elementName);
        }
    }

    public void enterText(WebElement element, String value, String elementName) {
        element.sendKeys(value);
        logInfo("Typing in : " + elementName + " entered the value as : " + value);
    }

    protected static void logInfo(String message) {
        ExtentListeners.testReport.get().info(message);
            ExtentManager.captureScreenshot();
            try {
                ExtentListeners.testReport.get().info(
                        "<b>" + "<font color=" + "blue>" + "Screenshot" + "</font>" + "</b>",
                        MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public static void logError(String message) {
        ExtentListeners.testReport.get().log(Status.FAIL,message);
        ExtentManager.captureScreenshot();
        try {
            ExtentListeners.testReport.get().fail(
                    "<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
        } catch (Exception e) {
            ExtentListeners.testReport.get().info("!Unable to Capture Screen Shot!");
        }
        ExtentListeners.overAllFailure = true;
    }

    public static void logWarning(String message) {
        ExtentListeners.testReport.get().warning(message);
    }

    public static void logAnnotation(String message) {
        ExtentListeners.testReport.get().log(Status.PASS,"<span style='background-color: darkblue'> <b>" + " <font color="
                + "white>" + message + "</font>" + "</b></span>");
    }
}
