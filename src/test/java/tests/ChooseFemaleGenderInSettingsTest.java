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

public class ChooseFemaleGenderInSettingsTest extends BaseTest {
    @Test
    @Description("Choose gender in settings")
    public void loginAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickEditProfile();
        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.chooseFemaleRadioButton();
        editProfilePage.clickSaveButton();

        Assert.assertTrue(settingsPage.getFemaleGender().contains("Female"),  "Wrong gender");
    }
}
