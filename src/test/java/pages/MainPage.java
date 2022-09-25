package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By logoutButton = By.xpath("//a[contains(@href, 'logout.cshtml')]");
    private By settingsButton = By.xpath("//a[contains(@href, 'UserProfile.cshtml')]");


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
}
