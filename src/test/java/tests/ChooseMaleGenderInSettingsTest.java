package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditProfilePage;
import pages.MainPage;
import pages.RegisterPage;
import pages.SettingsPage;

public class ChooseMaleGenderInSettingsTest extends BaseTest {
    @Test
    @Description("Choose gender in settings")
    public void loginAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAccount();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickEditProfile();
        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.chooseMaleRadioButton();
        editProfilePage.clickSaveButton();

        Assert.assertTrue(settingsPage.getMaleGender().contains("Male"),  "Wrong gender");
    }
}
