package demoqa.listeners;
import demoqa.drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListeners implements ITestListener {

    WebDriver driver = DriverManager.getDriver();

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' failed. Capturing screenshot...");
        if (driver != null) {
            saveScreenshotPNG();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite '" + context.getSuite().getName() + "' is starting.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' passed successfully.");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite '" + context.getSuite().getName() + "' has finished.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' was skipped.");
    }

}
