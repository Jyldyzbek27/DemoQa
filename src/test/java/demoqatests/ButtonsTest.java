package demoqatests;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {


    @Test(groups = {"UI", "DN-04"})
    @Description("Testing the functionality of buttons on the page")
    @Epic("Button Testing")
    @Story("Check the functionality of various types of buttons")
    @Feature("Button Testing: double click, right click, and dynamic click")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://demoqa.com/buttons")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-125")
    @Step("Perform double click, right click, and dynamic click on buttons")
    void testButtonsPage(){
        importHelpers.getBrowserManager().openURL("https://demoqa.com/buttons");
        webElementActions.doubleClick(demoqaPages.getButtonsPage().doubleClickButton);
        webElementActions.scrollToElement(demoqaPages.getButtonsPage().rightClickButton)
                .rightClick(demoqaPages.getButtonsPage().rightClickButton)
                .click(demoqaPages.getButtonsPage().clickClickButton);
        String expectedDoubleClickMessage = "You have done a double click";
        String expectedRightClickMessage = "You have done a right click";
        String expectedClickClickButtonMessage = "You have done a dynamic click";
        String actualDoubleClickMessage = webElementActions.getTextFromElement(demoqaPages.getButtonsPage().doubleClickMessage);
        String actualRightClickMessage = webElementActions.getTextFromElement(demoqaPages.getButtonsPage().rightClickMessage);
        String actualClickClickButtonMessage = webElementActions.getTextFromElement(demoqaPages.getButtonsPage().clickClickButtonMessage);
        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage);
        Assert.assertEquals(actualRightClickMessage, expectedRightClickMessage);
        Assert.assertEquals(actualClickClickButtonMessage, expectedClickClickButtonMessage);
    }
}
