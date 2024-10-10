package demoqa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AlertPage extends BasePage{

    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "promtButton")
    public WebElement promtButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmResult;

    @FindBy(id = "promptResult")
    public WebElement promptResult;

    public static void main(String[] args) throws IOException {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new java.io.File("src/main/resources/drivers/chromedriver.exe"))
                .build();
        service.start();
        Process process = Runtime.getRuntime().exec("src/main/resources/drivers/chromedriver.exe --version");
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        service.stop();
    }

}
