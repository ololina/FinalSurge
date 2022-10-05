package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LogoutPage.class.getName());

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    private By logoutMessage = By.xpath("//*[text()='You have been successfully logged out of the system.']");

    public boolean isLogoutMessageDisplayed() {
        LOGGER.info("Logout message is shown");
        boolean isLogoutButtonDisplayed = driver.findElement(logoutMessage).isDisplayed();
        return isLogoutButtonDisplayed;
    }
}
