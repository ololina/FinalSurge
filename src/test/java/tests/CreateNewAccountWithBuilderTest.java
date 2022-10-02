package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class CreateNewAccountWithBuilderTest extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 0, threadPoolSize = 2)
    @Description("New account creation")
    public void createAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());

        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }
}
