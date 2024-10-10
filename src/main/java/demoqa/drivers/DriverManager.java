package demoqa.drivers;

import demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

/**
 * Класс для управления WebDriver. Отвечает за создание и закрытие драйвера.
 */
public class DriverManager {

    private static WebDriver driver;

    /**
     * Возвращает экземпляр WebDriver на основе указанного в конфигурации браузера.
     * Если драйвер уже существует, возвращает его без создания нового.
     *
     * @return WebDriver
     * @throws IllegalArgumentException если имя браузера неверно.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getValue("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "fireFox":
                    // Заглушка для Firefox, может быть реализовано позже.
                    break;
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        }
        return driver;
    }

    /**
     * Закрывает текущий экземпляр WebDriver, если он существует.
     * При ошибке выводится сообщение об ошибке.
     */
    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.err.println("Error while closing driver");
        }
    }
}
