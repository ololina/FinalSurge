package tests;


import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.RetryAnalyzer;


public class LoginWithInvalidCredentials extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(LoginWithInvalidCredentials.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, threadPoolSize = 2)
    @Description("Log in with invalid credentials")
    public void loginAccountTest() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        loginPage.loginAccountWithInvalidCredentials();

        LOGGER.info("Check wrong credentials message is shown");
        Assert.assertTrue(loginPage.isWrongCredentialsMessageDisplayed(), "Message is not displayed");
    }
}
