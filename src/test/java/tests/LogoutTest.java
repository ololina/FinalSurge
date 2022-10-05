package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class LogoutTest extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(LogoutTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, threadPoolSize = 2)
    @Description("Log out from account test")
    public void logoutFromAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", RegisterPage.class.getName()));
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.clickLogout();
        LogoutPage logoutPage = new LogoutPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", LogoutTest.class.getName()));

        LOGGER.info("Check logout message is shown");
        Assert.assertTrue(logoutPage.isLogoutMessageDisplayed(), "Logout message is not displayed");
    }
}
