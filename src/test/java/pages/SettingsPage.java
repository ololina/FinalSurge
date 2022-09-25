package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    private By editProfilesButton = By.className("dropdown-toggle");
    private By nameField = By.xpath("//*[text()='Name:']");
    private By nameField2 = By.xpath("//div[contains(@class, 'span10')]//p[@class='formSep']");

    public void clickEditProfile() {
        driver.findElement(editProfilesButton).click();
    }

    public String getUpdatedLastName() {
        String updatedLastName = driver.findElement(nameField2).getText();
        return updatedLastName;
    }
}
