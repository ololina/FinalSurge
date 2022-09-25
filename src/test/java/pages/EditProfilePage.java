package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class EditProfilePage extends BasePage {
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }
    String newLastName = FakeMessageGenerator.generateSurname();

    private By lastNameInput = By.xpath("//div[contains(@class, 'span5')]//input[@name='lname']");
    private By saveButton = By.name("btnSubmit");
    private By maleRadioButton = By.xpath("//label[contains(@class, 'radio inline')]//input[@value='m']");
    private By femaleRadioButton = By.xpath("//label[contains(@class, 'radio inline')]//input[@value='f']");

    public void editLastName() {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(newLastName);
    }

    public String getUpdatedLastName() {
        return newLastName;
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void chooseMaleRadioButton() {
        driver.findElement(maleRadioButton).click();
    }

    public void chooseFemaleRadioButton() {
        driver.findElement(femaleRadioButton).click();
    }



}
