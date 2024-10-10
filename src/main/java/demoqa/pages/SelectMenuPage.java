package demoqa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends BasePage{

    @FindBy(id = "oldSelectMenu")
    public WebElement oldStyleSelectMenu;

}
