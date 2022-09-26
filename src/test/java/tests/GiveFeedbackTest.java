package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FeedbackPage;
import pages.MainPage;
import pages.RegisterPage;
import testdata.PrepareRegisterNewAccountData;

public class GiveFeedbackTest extends BaseTest {
    @Test
    @Description("Leave feedback test")
    public void giveFeedbackTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFeedbackButton();
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.giveFeedback();

        Assert.assertTrue(feedbackPage.isSuccessMessageDisplayed(), "Feedback is not submitted");
    }
}
