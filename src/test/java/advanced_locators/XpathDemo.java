package advanced_locators;
import demoqatests.BaseTest;
import demoqa.data.MockDataGenerator;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class XpathDemo extends BaseTest {

    @Test(groups = {"UI", "DN-01"})
    @Description("Checking the absolute path")
    @Epic("Path test")
    @Story("Checking paths")
    @Feature("Checking the absolute path of the submit button")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demoqa.com/text-box")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-221")
    @Step("Fill out the text box form and submit with absolut path")
    void absoluteXpathDemoTest() {
        importHelpers.getBrowserManager().openURL("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        demoqaPages.getTextBoxPage().fillUpTextBoxForm(MockDataGenerator.randomTextBox());
        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button"));
        webElementActions.click(submitBtn);
    }

    @Test(groups = {"UI", "DN-02"})
    @Description("Checking the relative path")
    @Epic("Path test")
    @Story("Checking paths")
    @Feature("Checking the relative path of the submit button")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demoqa.com/text-box")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-222")
    @Step("Fill out the text box form and submit with relative path")
    void relativeXpathDemoTest() {
        importHelpers.getBrowserManager().openURL("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        demoqaPages.getTextBoxPage().fillUpTextBoxForm(MockDataGenerator.randomTextBox());
        WebElement submitBtn = driver.findElement(By.id("submit"));
//        WebElement submitBtn1 = driver.findElement(By.xpath("//button[@type='button' and text()='Submit']"));
//        WebElement submitBtn2 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        webElementActions.click(submitBtn);
        //input[@placeholder='Full Name']
        //input[@placeholder='Full Name' and @type='text' or @id='userName']
        //*[@placeholder='Full Name']
        //div[@id='output']/div/p[@id='currentAddress']
        //p[@id='currentAddress']/..
        //h1[text()='Text Box']
        //h1[contains(text(),'Text')]
        //h3[contains(text(),'Фаиза / Faiza')]
        //h3[normalize-space()='Фаиза / Faiza']
        //span[starts-with(text(),'Перед')]
        //input[starts-with(@id,'userE')]
        //div[@id='brandsRefinements']/ul[1]/span/span[position()=3]
        //div[@id='brandsRefinements']/ul[1]/span/span[position()=4]
        //div[@id='brandsRefinements']/ul[1]/span/span[last()]
        //999.99     //span[round(text())='999] ---> 1000
        //999.99     //span[floor(text())='999] ---> 999
        //input[starts-with(@id,'user') and not(@type='text') ]
    }
    //div[@id='brandsRefinements']/ul/span/span/li/span/a/span


    //XPath Axes
    //1. parent --> //div[@id='brandsRefinements']/ul/span/span/parent::span or /..
    //2. child --> //div[@id='brandsRefinements']/ul[position()=1]/span/child::span
    //3. ancestor --> //span[text()='Apple' and @class='a-size-base a-color-base']/ancestor::ul
    //4. descendant  ---> //div[@id='brandsRefinements']/descendant::span
    //5. following-sibling ---> //div[@id='brandsRefinements']/ul/span/span/following-sibling::span[5]
    ////div[@id='brandsRefinements']/ul[position()=1]/span/span[1]/following-sibling::span[4]
    //6. preceding ---> //tbody/tr[2]/td[3]/preceding-sibling::td[2]

    @Test
    @Description("Checking amazon")
    @Epic("Checking the functionality")
    @Story("Functionality of the phones section")
    @Feature("Phone list")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.amazon.com/")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-223")
    @Step("Downloading a list of phones from Amazon")
    void amazonXpathDemoTest() throws InterruptedException {
        importHelpers.getBrowserManager().openURL("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(2000);
        List<String> mockBrands = Arrays.asList("Apple", "Boost Mobile", "Motorola", "Nokia", "Top Brands");
        for (String brand : mockBrands) {
            System.out.println(brand);
        }
    }
}