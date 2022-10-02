package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FeedbackPage;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class GiveFeedbackTest extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 8, threadPoolSize = 2)
    @Description("Leave feedback test")
    public void giveFeedbackTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());
        mainPage.clickFeedbackButton();
        FeedbackPage feedbackPage = new FeedbackPage(driverManager.getDriver());
        feedbackPage.giveFeedback();

        Assert.assertTrue(feedbackPage.isSuccessMessageDisplayed(), "Feedback is not submitted");
    }
}
