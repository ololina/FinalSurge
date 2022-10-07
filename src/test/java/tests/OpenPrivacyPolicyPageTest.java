package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PrivacyPolicyPage;
import pages.RegisterPage;
import utils.RetryAnalyzer;

public class OpenPrivacyPolicyPageTest extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(OpenPrivacyPolicyPageTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Open privacy policy page")
    public void createAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", RegisterPage.class.getName()));
        registerPage.openRegisterAccountPage();
        registerPage.openPrivacyPolicyPage();
        driverManager.switchTab();
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", PrivacyPolicyPage.class.getName()));

        LOGGER.info("Check privacy policy is shown");
        Assert.assertTrue(privacyPolicyPage.isPrivacyPolicyTextDisplayed(), "Privacy policy is not displayed");
    }
}
