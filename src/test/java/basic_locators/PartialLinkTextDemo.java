package basic_locators;
import demoqatests.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PartialLinkTextDemo extends BaseTest {

    @Test(groups = {"DB", "DN-0006"})
    @Description("Testing link functionality and window handling on DemoQA Links page")
    @Epic("Link and Window Handling")
    @Story("Click on 'Home' link and switch between windows")
    @Feature("Links")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.MINOR)
    @Link("https://demoqa.com/links")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-315")
    @Step("Click on the 'Home' link, handle multiple windows, and switch back to the original window")
    public void byLinkedText(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/links");

        Actions actions = new Actions(driver);

        String originalWindow = driver.getWindowHandle();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement homeLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Home")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", homeLink);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Closing window with handle: " + windowHandle);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);

        WebElement homeLinkD2 = driver.findElement(By.xpath("//a[@id='dynamicLink']"));
        js.executeScript("arguments[0].click();", homeLinkD2);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Closing window with handle: " + windowHandle);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);

        WebElement createdLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Created")));
        actions.scrollToElement(createdLink);
        js.executeScript("arguments[0].click();", createdLink);


        WebElement noContentLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("No Content")));
        actions.scrollToElement(noContentLink);
        js.executeScript("arguments[0].click();", noContentLink);

        WebElement movedLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Moved")));
        actions.scrollToElement(movedLink);
        js.executeScript("arguments[0].click();", movedLink);

        WebElement badRequestLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Request")));
        actions.scrollToElement(badRequestLink);
        js.executeScript("arguments[0].click();", badRequestLink);

        WebElement unauthorizedLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Unauthorized")));
        actions.scrollToElement(unauthorizedLink);
        js.executeScript("arguments[0].click();", unauthorizedLink);

        WebElement forbiddenLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Forbidden")));
        actions.scrollToElement(forbiddenLink);
        js.executeScript("arguments[0].click();", forbiddenLink);

        WebElement notFoundLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Found")));
        actions.scrollToElement(notFoundLink);
        js.executeScript("arguments[0].click();", notFoundLink);

    }
}