package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {

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
    }

    public void clickSettings() {
        driver.findElement(settingsButton).click();
    }

    public void clickFeedbackButton() {
        driver.findElement(giveFeedbackButton).click();
    }
}
