package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;

public class CreateNewAccountWithoutEmail extends BaseTest {

    @Test
    @Description("New account creation without email")
    public void createAccountWithoutEmailTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithoutEmail(registerNewAccountModel);

        Assert.assertTrue(registerPage.isRequiredFieldMessageDisplayed(), "Message is not displayed");
    }


}
