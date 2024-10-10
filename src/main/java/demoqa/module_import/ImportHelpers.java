package demoqa.module_import;
import demoqa.drivers.DriverManager;
import demoqa.helper.AlertHelper;
import demoqa.helper.BrowserManager;
import demoqa.helper.DropDownHelper;
import lombok.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class ImportHelpers {

    private WebDriver driver;
    private BrowserManager browserManager;
    private BrowserManager.WindowHelper windowHelper;
    private AlertHelper alertHelper;
    private DropDownHelper dropDownHelper;
    private WebDriverWait wait;
    private BrowserManager.IFrameHelper iFrameHelper;

    public ImportHelpers(WebDriver driver) {
        this.driver = driver;
        this.browserManager = new BrowserManager(driver);
        this.windowHelper = new BrowserManager.WindowHelper(driver);
        this.alertHelper = new AlertHelper(driver);
        this.dropDownHelper = new DropDownHelper(driver);
        this.wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        this.iFrameHelper = new BrowserManager.IFrameHelper(driver);
    }


}
