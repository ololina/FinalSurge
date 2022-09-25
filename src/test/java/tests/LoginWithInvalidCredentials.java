package tests;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginWithInvalidCredentials extends BaseTest {

    @Test
    @Description("Log in with invalid credentials")
    public void loginAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAccountWithInvalidCredentials();

        Assert.assertTrue(loginPage.isWrongCredentialsMessageDisplayed(), "Meessage is not displayed");
    }

}
