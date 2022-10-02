package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage extends BasePage {

    private static  final Logger LOGGER = LogManager.getLogger(PrivacyPolicyPage.class.getName());

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    private By privacyPolicyText = By.xpath("//div[contains(@class, 'intersection-block')]");

    public boolean isPrivacyPolicyTextDisplayed() {
        LOGGER.info("Privacy policy is shown");
        boolean isPrivacyPolicyTextDisplayed = driver.findElement(privacyPolicyText).isDisplayed();
        return isPrivacyPolicyTextDisplayed;
    }
}
