package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class UpdateLastNameTest extends BaseTest {

    @Test
    @Description("Update last name")
    public void updateLastNameTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAccount();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.clickEditProfile();
        EditProfilePage editProfilePage = new EditProfilePage(driver);
        editProfilePage.editLastName();
        String updatedLastName = editProfilePage.getUpdatedLastName();
        editProfilePage.clickSaveButton();

        Assert.assertTrue(settingsPage.getUpdatedLastName().contains(updatedLastName),  "Last name doesn't match");
    }
}
