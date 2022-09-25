package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    private By editProfilesButton = By.className("dropdown-toggle");
    private By nameField = By.xpath("//div[contains(@class, 'span10')]//p[@class='formSep']");
    private By maleGenderChoosen = By.xpath("//div[contains(@class, 'span10')]//p[text()=' Male']");
    private By femaleGenderChoosen = By.xpath("//div[contains(@class, 'span10')]//p[text()=' Female']");

    public void clickEditProfile() {
        driver.findElement(editProfilesButton).click();
    }

    public String getUpdatedLastName() {
        String updatedLastName = driver.findElement(nameField).getText();
        return updatedLastName;
    }

    public String getMaleGender() {
        String gender = driver.findElement(maleGenderChoosen).getText();
        return gender;
    }

    public String getFemaleGender() {
        String gender = driver.findElement(femaleGenderChoosen).getText();
        return gender;
    }
}
