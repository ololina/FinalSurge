package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    private By logoutMessage = By.xpath("//*[text()='You have been successfully logged out of the system.']");

    public boolean isLogoutMessageDisplayed() {
        boolean isLogoutButtonDisplayed = driver.findElement(logoutMessage).isDisplayed();
        return isLogoutButtonDisplayed;
    }
}
