package drivermanager;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    protected WebDriver driver;

    public abstract void createDriver();

    public WebDriver getDriver() {
        return driver;
    }

    public void startMaximize() {
        driver.manage().window().maximize();
    }

    public void setTimeout() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void removeTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void switchTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void quitDriver() {
        driver.quit();
    }
}
