package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoutPage;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;

public class LogoutTest extends BaseTest {
    @Test
    @Description("Log out from account test")
    public void logoutFromAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogout();
        LogoutPage logoutPage = new LogoutPage(driver);

        Assert.assertTrue(logoutPage.isLogoutMessageDisplayed(), "Logout message is not displayed");
    }
}
