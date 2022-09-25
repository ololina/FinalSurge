package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PrivacyPolicyPage;
import pages.RegisterPage;

public class OpenPrivacyPolicyPageTest extends BaseTest {

    @Test
    @Description("Open privacy policy page")
    public void createAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterAccountPage();
        registerPage.openPrivacyPolicyPage();
        driverManager.switchTab();
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(driver);

        Assert.assertTrue(privacyPolicyPage.isPrivacyPolicyTextDisplayed(), "Privacy policy is not displayed");
    }
}
