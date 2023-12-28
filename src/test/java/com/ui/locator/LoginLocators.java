package com.ui.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators {



    @FindBy(id = "user-name")
    public WebElement usernameTextBox ;

    @FindBy(id = "password")
    public WebElement passwordTextBox ;

    @FindBy(id = "login-button")
    public WebElement submitButton ;


    @FindBy(id ="react-burger-menu-btn")
    public WebElement homeBurgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton ;

    @FindBy(css = ".app_logo")
    public WebElement homePageLogo ;


}
