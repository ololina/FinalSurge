package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoutPage;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class LogoutTest extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 6, threadPoolSize = 2)
    @Description("Log out from account test")
    public void logoutFromAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());
        mainPage.clickLogout();
        LogoutPage logoutPage = new LogoutPage(driverManager.getDriver());

        Assert.assertTrue(logoutPage.isLogoutMessageDisplayed(), "Logout message is not displayed");
    }
}
