package demoqa.helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class DropDownHelper {

    private WebDriver driver;
    private WebDriverWait wait;


    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public DropDownHelper selectByVisibleText(WebElement element, String txt) {
        Select select = new Select(element);
        select.selectByVisibleText(txt);
        return this;
    }

    public DropDownHelper selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
        return this;
    }

    public DropDownHelper selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
        return this;
    }

    public List<String> getAllDropDownValues(WebElement webElement) {
        Select select = new Select(webElement);
        List<WebElement> elementList = select.getOptions();
        List<String> list = new LinkedList<>();
        for (WebElement element : elementList) {
            list.add(element.getText());
        }
        return list;
    }
}
