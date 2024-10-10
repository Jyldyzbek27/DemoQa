package basic_locators;
import demoqatests.BaseTest;
import demoqa.data.MockDataGenerator;
import io.qameta.allure.*;
import org.testng.annotations.Test;


public class ByClassDemo extends BaseTest {

    @Test
    @Description("Testing web table functionality on DemoQA")
    @Epic("Table Functionality")
    @Story("Adding a new record to the web table")
    @Feature("Web Tables")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://demoqa.com/webtables")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-312")
    @Step("Clicking on 'Add New Record' button and verifying table interaction")
    public void byClassDemo(){
        importHelpers.getBrowserManager().openURL("https://demoqa.com/webtables");
        demoqaPages.getWebTablePage().fillUpWebTable(MockDataGenerator.randomWebTableData());

    }
}
