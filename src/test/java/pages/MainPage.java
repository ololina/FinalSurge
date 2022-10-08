package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {

    private static  final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By logoutButton = By.xpath("//a[contains(@href, 'logout.cshtml')]");
    private By settingsButton = By.xpath("//a[contains(@href, 'UserProfile.cshtml')]");
    private By giveFeedbackButton = By.xpath("//*[contains(@href, 'Feedback.cshtml')]");


    public boolean isLogoutButtonDisplayed() {
        boolean isLogoutButtonDisplayed = driver.findElement(logoutButton).isDisplayed();
        return isLogoutButtonDisplayed;
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
        LOGGER.info("Logout button is clicked");
    }

    public void clickSettings() {
        driver.findElement(settingsButton).click();
        LOGGER.info("Settings button is clicked");
    }

    public void clickFeedbackButton() {
        driver.findElement(giveFeedbackButton).click();
        LOGGER.info("Feedback button is clicked");
    }
}
