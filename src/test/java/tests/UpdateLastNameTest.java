package tests;

import io.qameta.allure.Description;
import models.RegisterNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.PrepareRegisterNewAccountData;
import utils.RetryAnalyzer;

public class UpdateLastNameTest extends BaseWithThreadLocalTest {

    private static  final Logger LOGGER = LogManager.getLogger(UpdateLastNameTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 7, threadPoolSize = 2)
    @Description("Update last name")
    public void updateLastNameTest() {
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
        editProfilePage.editLastName();
        String updatedLastName = editProfilePage.getUpdatedLastName();
        editProfilePage.clickSaveButton();

        LOGGER.info("Check new last name is saved");
        Assert.assertTrue(settingsPage.getUpdatedLastName().contains(updatedLastName),  "Last name doesn't match");
    }
}
