package demoqatests;
import demoqa.enums.OldStyleSelectMenuValues;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.util.List;

public class SelectMenuTest extends BaseTest {

    @Test
    @Description("Testing the functionality of the select menu on DemoQA")
    @Epic("Select Menu Functionality")
    @Story("Select different options from the old style select menu")
    @Feature("Select Menu")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://demoqa.com/select-menu")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-320")
    @Step("Select colors from the old style select menu and print all available options")
    void selectMenuTest() throws InterruptedException {
        importHelpers.getBrowserManager().openURL("https://demoqa.com/select-menu");
        importHelpers.getDropDownHelper().selectByVisibleText(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, OldStyleSelectMenuValues.GREEN.getColor());
        Thread.sleep(3000);

        importHelpers.getDropDownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 7);
        Thread.sleep(3000);

        importHelpers.getDropDownHelper().selectByValue(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, "8");
        Thread.sleep(3000);

        importHelpers.getDropDownHelper().selectByValue(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, "red");
        Thread.sleep(3000);

        List<String> colors = importHelpers.getDropDownHelper().getAllDropDownValues(demoqaPages.getSelectMenuPage().oldStyleSelectMenu);
        for (String color: colors){
            System.out.println(color);
        }
        Thread.sleep(5000);
    }


}
