package demoqa.module_import;
import demoqa.pages.*;
import lombok.*;
import org.openqa.selenium.WebDriver;

@Getter
@AllArgsConstructor
@Setter
@Builder
public class DemoqaPages {
    WebDriver driver;
    public TextBoxPage textBoxPage;
    public PracticeFormPage practiceFormPage;
    public ButtonsPage buttonsPage;
    public BrowserWindowsPage browserWindowsPage;
    public AlertPage alertPage;
    public SelectMenuPage selectMenuPage;
    public LinkPage linkPage;
    public FramesPage framesPage;
    public WebTablePage webTablePage;



    public DemoqaPages() {
        textBoxPage = new TextBoxPage();
        buttonsPage = new ButtonsPage();
        browserWindowsPage = new BrowserWindowsPage();
        alertPage = new AlertPage();
        practiceFormPage = new PracticeFormPage();
        selectMenuPage = new SelectMenuPage();
        linkPage = new LinkPage();
        framesPage = new FramesPage();
        webTablePage = new WebTablePage();
    }
}
