package basic_locators;
import demoqatests.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByNameDemo extends BaseTest {

    @Test(groups = {"DB", "DN-0004"})
    @Description("Testing login functionality on OrangeHRM")
    @Epic("Login Functionality")
    @Story("Login to OrangeHRM with valid credentials")
    @Feature("Login Page")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-501")
    @Step("Login with valid username and password, and verify dashboard title")
    public void testOrangeHRM(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.sendKeys("Admin");
        WebElement userPasswordInput = driver.findElement(By.name("password"));
        userPasswordInput.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        String expectedTitle = "Dashboard";
        WebElement title = driver.findElement(By.xpath("//h6"));
        System.out.println(title);
        String actualTitle = title.getText();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
