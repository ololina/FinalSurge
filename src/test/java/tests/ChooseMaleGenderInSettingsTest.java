package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.MainPage;
import pages.RegisterPage;
import pages.SettingsPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class ChooseMaleGenderInSettingsTest extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(ChooseMaleGenderInSettingsTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 5, threadPoolSize = 2)
    @Description("Choose gender in settings")
    public void loginAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", RegisterPage.class.getName()));
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", SettingsPage.class.getName()));
        settingsPage.clickEditProfile();
        EditProfilePage editProfilePage = new EditProfilePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", EditProfilePage.class.getName()));
        editProfilePage.chooseMaleRadioButton();
        editProfilePage.clickSaveButton();

        LOGGER.info("Check chosen gender is correct");
        Assert.assertTrue(settingsPage.getMaleGender().contains("Male"),  "Wrong gender");
    }
}
