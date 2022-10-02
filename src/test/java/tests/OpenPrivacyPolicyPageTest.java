package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PrivacyPolicyPage;
import pages.RegisterPage;
import utils.RetryAnalyzer;

public class OpenPrivacyPolicyPageTest extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 9, threadPoolSize = 2)
    @Description("Open privacy policy page")
    public void createAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.openRegisterAccountPage();
        registerPage.openPrivacyPolicyPage();
        driverManager.switchTab();
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(driverManager.getDriver());

        Assert.assertTrue(privacyPolicyPage.isPrivacyPolicyTextDisplayed(), "Privacy policy is not displayed");
    }
}
