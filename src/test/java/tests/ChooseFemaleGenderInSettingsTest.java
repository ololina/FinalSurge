package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.MainPage;
import pages.RegisterPage;
import pages.SettingsPage;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class ChooseFemaleGenderInSettingsTest extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 4, threadPoolSize = 2)
    @Description("Choose gender in settings")
    public void loginAccountTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driverManager.getDriver());
        settingsPage.clickEditProfile();
        EditProfilePage editProfilePage = new EditProfilePage(driverManager.getDriver());
        editProfilePage.chooseFemaleRadioButton();
        editProfilePage.clickSaveButton();

        Assert.assertTrue(settingsPage.getFemaleGender().contains("Female"),  "Wrong gender");
    }
}
