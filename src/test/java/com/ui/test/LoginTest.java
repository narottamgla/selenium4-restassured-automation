package com.ui.test;

import com.ui.action.LoginActions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginActions loginAction ;
    @Test
    public void testLoginWithValiDetails() {
        loginAction = new LoginActions();
        loginAction.navigateToLoginPage();
        loginAction.login("standard_user", "secret_sauce");
        loginAction.isLoginSuccessful();
        loginAction.logout();
    }
}
