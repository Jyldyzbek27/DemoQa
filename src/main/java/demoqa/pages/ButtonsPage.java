package demoqa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage{


 @FindBy(id = "doubleClickBtn")
 public WebElement doubleClickButton;

 @FindBy(id = "rightClickBtn")
 public WebElement rightClickButton;

 @FindBy(xpath = "//button[text()='Click Me']")
 public WebElement clickClickButton;

 @FindBy(id = "doubleClickMessage")
 public WebElement doubleClickMessage;

 @FindBy(id = "rightClickMessage")
 public WebElement rightClickMessage;

 @FindBy(id = "dynamicClickMessage")
 public WebElement clickClickButtonMessage;


}
