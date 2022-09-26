package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;


public class LoginTest extends BaseTest {

    @Test
    @Description("Log in by existed account")
    public void loginAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccount();
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }
}
