package pages;

import constants.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class EditProfilePage extends BasePage {
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }
    String newLastName = FakeMessageGenerator.generateSurname();

    private By lastNameInput = By.id("lname");
    private By saveButton = By.name("btnSubmit");

    public void editLastName() {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(newLastName);
    }

    public String getUpdatedLastName() {
        String updatedLastName = driver.findElement(lastNameInput).getText();
        return updatedLastName;
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }



}
