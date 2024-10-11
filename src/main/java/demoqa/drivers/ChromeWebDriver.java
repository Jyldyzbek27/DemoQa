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
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

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