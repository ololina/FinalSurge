package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

public class FeedbackPage extends BasePage {

    public FeedbackPage(WebDriver driver) {
        super(driver);
    }

    private By phoneInput = By.xpath("//div[contains(@class, 'formSep')]//input[@name='Phone']");
    private By reasonDropDown = By.xpath("//div[contains(@class, 'formSep')]//select[@name='Reason']");
    private By feedbackInput = By.xpath("//div[contains(@class, 'formSep')]//textarea[@name='Feedback']");
    private By submitButton = By.xpath("//div[contains(@class, 'formSep sepH_b')]//input[@type='submit']");
    private By successMessage = By.xpath("//div[contains(@class,'alert')]");

    //private By loginButton = By.xpath("//div[contains(@class, 'submit_sect')]//button[@type='submit']");


    @Step("Leave feedback")
    public void giveFeedback() {

        driver.findElement(phoneInput).sendKeys(FakeMessageGenerator.generatePhoneNumber());
        Select select = new Select(driver.findElement(reasonDropDown));
        select.selectByIndex(2);
        driver.findElement(feedbackInput).sendKeys(FakeMessageGenerator.generateRandomText());
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        boolean isSuccessMessageDisplayed = driver.findElement(successMessage).isDisplayed();
        return isSuccessMessageDisplayed;
    }
}
