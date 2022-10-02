package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class CreateNewAccountWithoutEmail extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 1, threadPoolSize = 2)
    @Description("New account creation without email")
    public void createAccountWithoutEmailTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithoutEmail(registerNewAccountModel);

        Assert.assertTrue(registerPage.isRequiredFieldMessageDisplayed(), "Message is not displayed");
    }


}
