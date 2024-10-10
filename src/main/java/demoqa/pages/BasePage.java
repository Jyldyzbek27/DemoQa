package demoqa.pages;
import com.github.javafaker.Faker;
import demoqa.data.MockDataGenerator;
import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;



public abstract class BasePage {

    WebElementActions webElementActions = new WebElementActions();
    MockDataGenerator generator = new MockDataGenerator();
    Random random = new Random();
    Faker faker = new Faker();

    public BasePage() {
        // Инициализация элементов страницы
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
