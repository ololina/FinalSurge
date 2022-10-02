package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.FakeMessageGenerator;

public class FeedbackPage extends BasePage {

    private static  final Logger LOGGER = LogManager.getLogger(FeedbackPage.class.getName());

    public FeedbackPage(WebDriver driver) {
        super(driver);
    }

    private By phoneInput = By.xpath("//div[contains(@class, 'formSep')]//input[@name='Phone']");
    private By reasonDropDown = By.xpath("//div[contains(@class, 'formSep')]//select[@name='Reason']");
    private By feedbackInput = By.xpath("//div[contains(@class, 'formSep')]//textarea[@name='Feedback']");
    private By submitButton = By.xpath("//div[contains(@class, 'formSep sepH_b')]//input[@type='submit']");
    private By successMessage = By.xpath("//div[contains(@class,'alert')]");


    @Step("Leave feedback")
    public void giveFeedback() {

        driver.findElement(phoneInput).sendKeys(FakeMessageGenerator.generatePhoneNumber());
        LOGGER.info("Phone number is entered");
        Select select = new Select(driver.findElement(reasonDropDown));
        select.selectByIndex(2);
        LOGGER.info("Reason of feedback is chosen");
        driver.findElement(feedbackInput).sendKeys(FakeMessageGenerator.generateRandomText());
        driver.findElement(submitButton).click();
        LOGGER.info("Feedback is left");
    }

    public boolean isSuccessMessageDisplayed() {
        LOGGER.info("Success message is shown");
        boolean isSuccessMessageDisplayed = driver.findElement(successMessage).isDisplayed();
        return isSuccessMessageDisplayed;
    }
}
