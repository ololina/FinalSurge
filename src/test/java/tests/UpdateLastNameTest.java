package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class UpdateLastNameTest extends BaseWithThreadLocalTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 7, threadPoolSize = 2)
    @Description("Update last name")
    public void updateLastNameTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        RegisterNewAccountModel registerNewAccountModel = PrepareRegisterNewAccountData.getValidData();
        registerPage.registerAccountWithBuilder(registerNewAccountModel);
        MainPage mainPage = new MainPage(driverManager.getDriver());
        mainPage.clickSettings();
        SettingsPage settingsPage = new SettingsPage(driverManager.getDriver());
        settingsPage.clickEditProfile();
        EditProfilePage editProfilePage = new EditProfilePage(driverManager.getDriver());
        editProfilePage.editLastName();
        String updatedLastName = editProfilePage.getUpdatedLastName();
        editProfilePage.clickSaveButton();

        Assert.assertTrue(settingsPage.getUpdatedLastName().contains(updatedLastName),  "Last name doesn't match");
    }
}
