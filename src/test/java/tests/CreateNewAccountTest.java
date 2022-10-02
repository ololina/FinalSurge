package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;
import utils.RetryAnalyzer;

public class CreateNewAccountTest extends BaseTest {

    private static  final Logger LOGGER = LogManager.getLogger(CreateNewAccountTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("New account creation")
    public void createAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        LOGGER.info(String.format("Page %s initialized", RegisterPage.class.getName()));
        registerPage.registerAccount();
        MainPage mainPage = new MainPage(driver);
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));

        LOGGER.info("Check user is logged in");
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }
}
