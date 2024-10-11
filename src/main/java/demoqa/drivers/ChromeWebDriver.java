package demoqa.drivers;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;

import java.time.Duration;

import static demoqa.utils.ConfigReader.getValue;

/**
 * Класс для настройки и инициализации веб-драйвера Chrome.
 */
public class ChromeWebDriver {

    /**
     * Загружает и конфигурирует экземпляр Chrome WebDriver.
     * <p>
     * Устанавливает путь к драйверу, открывает окно браузера в полном экране,
     * а также задает неявное ожидание для поиска элементов.
     *
     * @return настроенный экземпляр WebDriver для браузера Chrome
     */
    public static WebDriver loadChromeDriver() {
        WebDriverManager.chromedriver().setup();
        LoggingPreferences logPrefs = new LoggingPreferences();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size-1920,1080");
        options.addArguments("--disable-gpu");
        //options.addArguments("--window-position=-2000,0");
        options.setCapability("goog:loggingPrefs", logPrefs);
        System.out.println("Headless mode: " + getValue("headless"));

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}