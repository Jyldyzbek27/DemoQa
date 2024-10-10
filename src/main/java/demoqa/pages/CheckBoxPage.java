package demoqa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

    @FindBy(css = ".rct-icon.rct-icon-expand-open")
    public WebElement homeDropDownBtn;

    @FindBy(css = ".rct-icon.rct-icon-expand-close")
    public WebElement desktopDropDownBtn;

    //@FindBy(css = ".rct-icon.rct-icon-expand-close")


}
