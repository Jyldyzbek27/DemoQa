package demoqa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends BasePage{

    @FindBy(id  = "tabButton")
    public WebElement newTab;
}
