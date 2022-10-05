package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class EditProfilePage extends BasePage {

    private static  final Logger LOGGER = LogManager.getLogger(EditProfilePage.class.getName());

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
        LOGGER.info("New last name is entered");
    }

    public String getUpdatedLastName() {
        return newLastName;
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
        LOGGER.info("New last name is saved");
    }

    public void chooseMaleRadioButton() {
        driver.findElement(maleRadioButton).click();
        LOGGER.info("Male gender is chosen");
    }

    public void chooseFemaleRadioButton() {
        driver.findElement(femaleRadioButton).click();
        LOGGER.info("Female gender is chosen");
    }
}
