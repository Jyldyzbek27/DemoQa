package basic_locators;
import demoqatests.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByTagName extends BaseTest {

    @Test(groups = {"DB", "DN-0005"})
    @Description("Testing the presence of H1 tag on DemoQA Text Box page")
    @Epic("Text Box Page Functionality")
    @Story("Verify the header on the Text Box page")
    @Feature("Headers")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://demoqa.com/text-box")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-410")
    @Step("Check the presence of H1 tag on the text box page")
    public void byTagDemo(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box");
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());

    }
}