package drivermanager;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.PropertyManager;

public class SafariDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        String os = System.getProperty("os.name");
        String path = "PATH_TO_CHROME_WIN";
        if (!os.contains("Windows")) {
            path = "PATH_TO_CHROME_MAC";
        }

        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.safari.driver", propertyManager.get(path));
        SafariOptions options = new SafariOptions();
        driver = new SafariDriver(options);
    }
}
