package demoqatests;
import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import demoqa.module_import.DemoqaPages;
import demoqa.module_import.ImportHelpers;
import demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    public WebDriver driver;
    public DemoqaPages demoqaPages;
    public ImportHelpers importHelpers;
    public RandomUtils randomUtils;
    public Actions actions;
    public WebElementActions webElementActions;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        demoqaPages = new DemoqaPages();
        importHelpers = new ImportHelpers(driver);
        randomUtils = new RandomUtils();
        actions = new Actions(driver);
        webElementActions = new WebElementActions();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
