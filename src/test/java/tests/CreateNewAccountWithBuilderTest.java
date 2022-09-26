package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;

public class CreateNewAccountWithBuilderTest extends BaseTest {

    @Test
    @Description("New account creation")
    public void createAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }
}
