package some_tests;
import demoqatests.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AmazonTest extends BaseTest {

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
    public void amazonXpathDemoTest() throws InterruptedException {
        importHelpers.getBrowserManager().openURL("https://www.amazon.com");
        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Цикл по кликам на каждый бренд
        for (int i = 0; i < 8; i++) { // Если точно знаем, что 7 элементов
            // Обновляем список перед каждым кликом, так как DOM может измениться
            List<WebElement> brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a"));

            // Используем метод clickElementWithRetry
            clickElementWithRetry(By.xpath("(//div[@id='brandsRefinements']/ul/span/span/li/span/a)[" + (i + 1) + "]"));

            Thread.sleep(5000); // Ждем перед возвратом назад
            driver.navigate().back();
        }
    }

    public void clickElementWithRetry(By locator) {
        int attempts = 0;
        while (attempts < 3) { // Пробуем кликнуть несколько раз
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                break; // Если успешно кликнули, выходим из цикла
            } catch (StaleElementReferenceException e) {
                attempts++; // Увеличиваем счетчик попыток
            }
        }
    }

}