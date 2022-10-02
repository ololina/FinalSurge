package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.RetryAnalyzer;


public class LoginTest extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 2, threadPoolSize = 2)
    @Description("Log in by existed account")
    public void loginAccountTest() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.loginAccount();
        MainPage mainPage = new MainPage(driverManager.getDriver());

        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }
}
