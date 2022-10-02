package tests;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.RetryAnalyzer;


public class LoginWithInvalidCredentials extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 3, threadPoolSize = 2)
    @Description("Log in with invalid credentials")
    public void loginAccountTest() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.loginAccountWithInvalidCredentials();

        Assert.assertTrue(loginPage.isWrongCredentialsMessageDisplayed(), "Message is not displayed");
    }

}
