package pages;

import constants.Urls;
import io.qameta.allure.Step;
import models.RegisterNewAccountModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;

public class RegisterPage extends BasePage {

    private static  final Logger LOGGER = LogManager.getLogger(RegisterPage.class.getName());

    private By firstNameInput = By.id("create_first");
    private By lastNameInput = By.id("create_last");
    private By emailInput = By.id("create_email");
    private By passwordInput = By.id("password_meter");
    private By passwordConfirmInput = By.id("create_passwordmatch");
    private By createNewAccountButton = By.xpath("//div[contains(@class, 'submit_sect')]//button[@type='submit']");
    private By requiredFieldMessage = By.xpath("//*[text()='This field is required.']");
    private By privacyPolicy = By.xpath("//a[contains(@href, 'https://www.finalsurge.com/PrivacyTerms#privacy')]");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open register page")
    public void openRegisterAccountPage() {
        driver.get(Urls.REGISTER_URL);
        LOGGER.info(String.format("Page %s is opened", RegisterPage.class.getName()));
    }

    public void registerAccountWithBuilder(RegisterNewAccountModel data) {
        driver.get(Urls.REGISTER_URL);
        LOGGER.info(String.format("Page %s is opened", RegisterPage.class.getName()));
        driver.findElement(firstNameInput).sendKeys(data.getFirstName());
        LOGGER.info("First name is entered");
        driver.findElement(lastNameInput).sendKeys(data.getLastName());
        LOGGER.info("Last name is entered");
        driver.findElement(emailInput).sendKeys(data.getEmailAddress());
        LOGGER.info("Email is entered");
        driver.findElement(passwordInput).sendKeys(data.getPassword());
        LOGGER.info("Password is entered");
        driver.findElement(passwordConfirmInput).sendKeys(data.getMatchPassword());
        LOGGER.info("Password is confirmed");
        driver.findElement(createNewAccountButton).click();
        LOGGER.info("New account is created");
    }

    @Step("Register account")
    public void registerAccount() {
        driver.get(Urls.REGISTER_URL);
        LOGGER.info(String.format("Page %s is opened", RegisterPage.class.getName()));
        driver.findElement(firstNameInput).sendKeys(FakeMessageGenerator.generateName());
        LOGGER.info("First name is entered");
        driver.findElement(lastNameInput).sendKeys(FakeMessageGenerator.generateSurname());
        LOGGER.info("Last name is entered");
        driver.findElement(emailInput).sendKeys(FakeMessageGenerator.generateEmail());
        LOGGER.info("Email is entered");
        String password = FakeMessageGenerator.generatePassword();
        driver.findElement(passwordInput).sendKeys(password);
        LOGGER.info("Password is entered");
        driver.findElement(passwordConfirmInput).sendKeys(password);
        LOGGER.info("Password is confirmed");
        driver.findElement(createNewAccountButton).click();
        LOGGER.info("New account is created");
    }

    @Step("Register account without Email")
    public void registerAccountWithoutEmail(RegisterNewAccountModel data) {
        driver.get(Urls.REGISTER_URL);
        LOGGER.info(String.format("Page %s is opened", RegisterPage.class.getName()));
        driver.findElement(firstNameInput).sendKeys(data.getFirstName());
        LOGGER.info("First name is entered");
        driver.findElement(lastNameInput).sendKeys(data.getLastName());
        LOGGER.info("Last name is entered");
        driver.findElement(passwordInput).sendKeys(data.getPassword());
        LOGGER.info("Password is entered");
        driver.findElement(passwordConfirmInput).sendKeys(data.getMatchPassword());
        LOGGER.info("Password is confirmed");
        driver.findElement(createNewAccountButton).click();
        LOGGER.info("Email field is empty");
    }

    @Step("Open Privacy Policy page")
    public void openPrivacyPolicyPage() {
        driver.findElement(privacyPolicy).click();
        LOGGER.info("Privacy policy is clicked");
    }

    public boolean isRequiredFieldMessageDisplayed() {
        LOGGER.info("Required field message is displayed");
        boolean isRequiredFieldMessageDisplayed = driver.findElement(requiredFieldMessage).isDisplayed();
        return isRequiredFieldMessageDisplayed;
    }
}
