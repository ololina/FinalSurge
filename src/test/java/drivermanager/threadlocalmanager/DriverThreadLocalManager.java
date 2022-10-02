package drivermanager.threadlocalmanager;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class DriverThreadLocalManager {

    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public abstract void createDriver();

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public void startMaximize() {
        threadLocalDriver.get().manage().window().maximize();
    }

    public void setTimeout() {
        threadLocalDriver.get().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    public void removeTimeout() {
        threadLocalDriver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void switchTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(threadLocalDriver.get().getWindowHandles());
        threadLocalDriver.get().switchTo().window(tabs2.get(1));
    }

    public void quitDriver() {
        getDriver().quit();
    }
}
