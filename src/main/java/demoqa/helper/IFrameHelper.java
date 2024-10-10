package demoqa.helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IFrameHelper {

    private WebDriver driver;


    public IFrameHelper(WebDriver driver) {

        this.driver = driver;
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void switchToFrame(String nameOrID){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
    }
}
