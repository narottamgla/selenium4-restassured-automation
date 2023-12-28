package com.ui.action;

import com.ui.driverutils.DriverManager;
import com.ui.locator.LoginLocators;
import com.ui.seleniumutils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginActions extends PageActions {

    LoginLocators loginLocators = new LoginLocators();
    WebDriver driver;


    public LoginActions() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, loginLocators);
    }
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }


    public void login(String username, String password) {
        enterText(loginLocators.usernameTextBox,username,"User Name TextBox");
        enterText(loginLocators.passwordTextBox,password,"Password TextBox");
        click(loginLocators.submitButton,"Submit Button");
    }

    public void isLoginSuccessful() {
        Assert.assertEquals(loginLocators.homePageLogo.isDisplayed(), true,"Login is not successful");
    }

    public void logout() {
        click(loginLocators.homeBurgerMenu,"HomeBurger Menu");
        WaitUtils.waitForSecond(3);
        click(loginLocators.logoutButton,"Logout Button");
    }
}
