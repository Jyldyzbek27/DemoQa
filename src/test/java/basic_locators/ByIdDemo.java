package basic_locators;
import demoqatests.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByIdDemo extends BaseTest {

    @Test(groups = {"DB", "DN-0002"})
    @Description("Testing text box functionality on DemoQA")
    @Epic("Text-Box Functionality")
    @Story("Adding a new record to the text box form")
    @Feature("Text box")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://demoqa.com/text-box")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-313")
    @Step("Fill up the form for the text box")
    public void byIdTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box");

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("JohnDoe@gmail.com");

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("Manasa 123");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Chui 123");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        actions.scrollToElement(submitBtn).perform();
        submitBtn.click();


        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        String inputNameValue = fullNameInput.getAttribute("value");
        String fullNameText = nameElement.getText();
        String extractedName = fullNameText.split(":")[1].trim();
        Assert.assertEquals(inputNameValue, extractedName);
        System.out.println("Actual name input: " + inputNameValue);
        System.out.println("Expected name value " + extractedName);

        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        String inputEmailValue = emailInput.getAttribute("value");
        String fullEmailText = emailElement.getText();
        String extractedEmail = fullEmailText.split(":")[1].trim();
        Assert.assertEquals(inputEmailValue, extractedEmail);
        System.out.println("Actual email input: " + inputEmailValue);
        System.out.println("Expected email value " + extractedEmail);

        WebElement currentAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mb-1' and @id='currentAddress']")));
        String inputCurrentAddressValue = currentAddressInput.getAttribute("value");
        String fullCurrentAddressText = currentAddressElement.getText();
        String extractedCurrentAddress = fullCurrentAddressText.split(":")[1].trim();
        Assert.assertEquals(inputCurrentAddressValue, extractedCurrentAddress);
        System.out.println("Actual current address input: " + inputCurrentAddressValue);
        System.out.println("Expected current address value " + extractedCurrentAddress);

        WebElement permanentAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='permanentAddress']")));
        String inputPermanentAddressValue = permanentAddress.getAttribute("value");
        String fullPermanentAddressText = permanentAddressElement.getText();
        String extractedPermanentAddress = fullPermanentAddressText.split(":")[1].trim();
        Assert.assertEquals(inputPermanentAddressValue, extractedPermanentAddress);
        System.out.println("Actual permanent address input: " + inputPermanentAddressValue);
        System.out.println("Expected permanent address value " + extractedPermanentAddress);


    }

}
