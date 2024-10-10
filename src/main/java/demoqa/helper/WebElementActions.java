package demoqa.helper;
import demoqa.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс предоставляет вспомогательные методы для работы с элементами на веб-странице.
 * Методы включают клики, ввод текста, перемещение к элементам и прокрутку страницы.
 */
public class WebElementActions {

    Actions actions = new Actions(DriverManager.getDriver());

    /**
     * Кликает по указанному элементу.
     *
     * @param element элемент, по которому необходимо кликнуть
     * @return WebElementActions для цепочки вызовов
     */
    public WebElementActions click(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    /**
     * Вводит текст в указанный элемент.
     *
     * @param element элемент, в который вводится текст
     * @param txt     текст для ввода
     * @return WebElementActions для цепочки вызовов
     */
    public WebElementActions input(WebElement element, String txt) {
        element.sendKeys(txt);
        return this;
    }

    /**
     * Перемещает курсор к указанному элементу.
     *
     * @param element элемент, к которому необходимо переместиться
     * @return WebElementActions для цепочки вызовов
     */
    public WebElementActions navigateToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
        return this;
    }

    /**
     * Прокручивает страницу к указанному элементу.
     *
     * @param element элемент, к которому необходимо прокрутить
     * @return WebElementActions для цепочки вызовов
     */
    public WebElementActions scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public String getTextFromElement(WebElement element) {
        waitElementToBeVisible(element);
        return element.getText();
    }

    public WebElementActions doubleClick(WebElement element) {
        waitElementToBeClickable(element);
        actions.doubleClick(element).build().perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Element is null. Cannot perform right-click.");
        }

        waitElementToBeClickable(element);
        actions.contextClick(element).build().perform();
        return this;
    }

//    public WebElementActions waitElementToBeClickable() {
//        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
//
//    }

}
