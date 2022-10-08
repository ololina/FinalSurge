package drivermanager.threadlocalmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverThreadLocalManager extends DriverThreadLocalManager {

    @Override
    public void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        threadLocalDriver.set(new FirefoxDriver());
    }
}
