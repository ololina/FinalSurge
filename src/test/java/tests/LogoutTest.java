package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoutPage;
import pages.MainPage;
import pages.RegisterPage;

public class LogoutTest extends BaseTest {
    @Test
    @Description("New account creation")
    public void logoutFromAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAccount();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogout();
        LogoutPage logoutPage = new LogoutPage(driver);

        Assert.assertTrue(logoutPage.isLogoutMessageDisplayed(), "Logout message is not displayed");
    }
}
