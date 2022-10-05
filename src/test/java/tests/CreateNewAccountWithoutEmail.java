package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class CreateNewAccountWithoutEmail extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(CreateNewAccountWithoutEmail.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, threadPoolSize = 2)
    @Description("New account creation without email")
    public void createAccountWithoutEmailTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", RegisterPage.class.getName()));
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithoutEmail(registerNewAccountModel);

        LOGGER.info("Check message is shown - Email field is empty");
        Assert.assertTrue(registerPage.isRequiredFieldMessageDisplayed(), "Message is not displayed");
    }
}
