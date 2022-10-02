package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(Paths.get("src/test/resources/screenshot.png"), sourceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
