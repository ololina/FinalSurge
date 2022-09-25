package drivermanager;

public class DriverFactory {

    public DriverManager getManager(DriverType driverType) {
        DriverManager driverManager;

        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManagerBoniGarcia();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type" + driverType);
        }
        return driverManager;
    }
}
