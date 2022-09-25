package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;

public class CreateNewAccountWithoutEmail extends BaseTest {

    @Test
    @Description("New account creation")
    public void createAccountWithoutEmailTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAccountWithoutEmail();

        Assert.assertTrue(registerPage.isRequiredFieldMessageDisplayed(), "Message is not displayed");
    }


}
