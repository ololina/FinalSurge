package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakeMessageGenerator;


public class LoginPage extends BasePage {

    private By emailInput = By.id("login_name");
    private By passwordInput = By.id("login_password");
    private By loginButton = By.xpath("//div[contains(@class, 'submit_sect')]//button[@type='submit']");
    private String wrongPassword = FakeMessageGenerator.generatePassword();
    private By wrongCredentialsMessage = By.xpath("//*[text()='Invalid login credentials. Please try again.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Log in to account")
    public void loginAccount() {
        driver.get(Urls.LOGIN_URL);
        driver.findElement(emailInput).sendKeys(Credentials.USERNAME);
        driver.findElement(passwordInput).sendKeys(Credentials.PASSWORD);
        driver.findElement(loginButton).click();
    }

    @Step("Log in to account with invalid credentials")
    public void loginAccountWithInvalidCredentials() {
        driver.get(Urls.LOGIN_URL);
        driver.findElement(emailInput).sendKeys(Credentials.USERNAME);
        driver.findElement(passwordInput).sendKeys(wrongPassword);
        driver.findElement(loginButton).click();
    }

    public boolean isWrongCredentialsMessageDisplayed() {
        boolean isWrongCredentialsMessageDisplayed = driver.findElement(wrongCredentialsMessage).isDisplayed();
        return isWrongCredentialsMessageDisplayed;
    }



}
