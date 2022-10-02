package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FeedbackPage;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class GiveFeedbackTest extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(GiveFeedbackTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 8, threadPoolSize = 2)
    @Description("Leave feedback test")
    public void giveFeedbackTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", RegisterPage.class.getName()));
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.clickFeedbackButton();
        FeedbackPage feedbackPage = new FeedbackPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", FeedbackPage.class.getName()));
        feedbackPage.giveFeedback();

        LOGGER.info("Check feedback is submitted");
        Assert.assertTrue(feedbackPage.isSuccessMessageDisplayed(), "Feedback is not submitted");
    }
}
