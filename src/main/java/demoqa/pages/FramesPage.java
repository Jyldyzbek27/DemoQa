package demoqa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage{

    @FindBy(id = "sampleHeading")
    public WebElement sampleHeading;

    @FindBy(id = "frame1")
    public WebElement frame1;

    @FindBy(css = ".text-center")
    public WebElement textCenter;
}
