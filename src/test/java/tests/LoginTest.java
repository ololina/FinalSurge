package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.RetryAnalyzer;


public class LoginTest extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 2, threadPoolSize = 2)
    @Description("Log in by existed account")
    public void loginAccountTest() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        loginPage.loginAccount();
        MainPage mainPage = new MainPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));

        LOGGER.info("Check user is logged in");
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }
}
