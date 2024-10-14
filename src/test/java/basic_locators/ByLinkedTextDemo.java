package basic_locators;
import demoqatests.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByLinkedTextDemo extends BaseTest {

    @Test(groups = {"DB", "DN-0003"})
    @Description("Testing link functionality on DemoQA")
    @Epic("Link Functionality")
    @Story("Clicking the 'Home' link on the links page")
    @Feature("Links")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demoqa.com/links")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-314")
    @Step("Click on the 'Home' link and verify the navigation")
    public void byLinkedText() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/links");

        WebElement homeLink = driver.findElement(By.linkText("Home"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", homeLink);
        Thread.sleep(4000);

    }
}