package tests;

import drivermanager.DriverType;
import drivermanager.threadlocalmanager.DriverThreadLocalManager;
import drivermanager.threadlocalmanager.DriverThreadLocalManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class BaseWithThreadLocalTest {

    DriverThreadLocalManager driverManager;

    @BeforeClass
    public void createManager() {
        DriverThreadLocalManagerFactory factory = new DriverThreadLocalManagerFactory();
        driverManager = factory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void setUp() {
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
    }

    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.getDriver().quit();
    }
}
