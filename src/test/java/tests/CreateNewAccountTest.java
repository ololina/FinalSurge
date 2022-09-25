package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterPage;

public class CreateNewAccountTest extends BaseTest {

    @Test
    @Description("New account creation")
    public void createAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAccountWithoutEmail();
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isLogoutButtonDisplayed(), "Logout button is not displayed");
    }
}
