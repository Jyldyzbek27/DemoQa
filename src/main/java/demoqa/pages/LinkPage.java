package demoqa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LinkPage extends BasePage {

    @FindBy(partialLinkText = "Home")
    public WebElement homeLink;

    @FindBy(xpath = "//a[@id='dynamicLink']")
    public WebElement dynamicHomeLink;


    @FindBy(partialLinkText = "Created")
    public WebElement createdLink;


    @FindBy(partialLinkText = "No Content")
    public WebElement noContentLink;

    @FindBy(partialLinkText = "Moved")
    public WebElement movedLink;

    @FindBy(partialLinkText = "Request")
    public WebElement badRequestLink;

    @FindBy(partialLinkText = "Unauthorized")
    public WebElement unauthorizedLink;

    @FindBy(partialLinkText = "Forbidden")
    public WebElement forbiddenLink;

    @FindBy(partialLinkText = "Found")
    public WebElement notFoundLink;

    @FindBy(id = "linkResponse")
    public WebElement linkResponse;



}
