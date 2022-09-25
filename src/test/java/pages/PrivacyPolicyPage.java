package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage extends BasePage {
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    private By privacyPolicyText = By.xpath("//div[contains(@class, 'intersection-block')]");

    public boolean isPrivacyPolicyTextDisplayed() {
        boolean isPrivacyPolicyTextDisplayed = driver.findElement(privacyPolicyText).isDisplayed();
        return isPrivacyPolicyTextDisplayed;
    }
}
