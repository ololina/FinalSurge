package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class RegisterPage extends BasePage {

    private By firstNameInput = By.id("create_first");
    private By lastNameInput = By.id("create_last");
    private By emailInput = By.id("create_email");
    private By passwordInput = By.id("password_meter");
    private By passwordConfirmInput = By.id("create_passwordmatch");
    private By createNewAccountButton = By.xpath("//div[contains(@class, 'submit_sect')]//button[@type='submit']");
    private By requiredFieldMessage = By.xpath("//*[text()='This field is required.']");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Register account")
    public void registerAccount() {
        driver.get(Urls.REGISTER_URL);
        driver.findElement(firstNameInput).sendKeys(FakeMessageGenerator.generateName());
        driver.findElement(lastNameInput).sendKeys(FakeMessageGenerator.generateSurname());
        driver.findElement(emailInput).sendKeys(FakeMessageGenerator.generateEmail());
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(passwordConfirmInput).sendKeys(password);
        driver.findElement(createNewAccountButton).click();

    }

    @Step("Register account without Email")
    public void registerAccountWithoutEmail() {
        driver.get(Urls.REGISTER_URL);
        driver.findElement(firstNameInput).sendKeys(FakeMessageGenerator.generateName());
        driver.findElement(lastNameInput).sendKeys(FakeMessageGenerator.generateSurname());
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(passwordConfirmInput).sendKeys(password);
        driver.findElement(createNewAccountButton).click();
    }

    public boolean isRequiredFieldMessageDisplayed() {
        boolean isRequiredFieldMessageDisplayed = driver.findElement(requiredFieldMessage).isDisplayed();
        return isRequiredFieldMessageDisplayed;
    }
}
