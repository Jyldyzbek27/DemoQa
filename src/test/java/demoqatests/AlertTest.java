package demoqatests;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test(groups = {"UI", "DN-03"})
    @Description("Checking the operation of alerts on the page")
    @Epic("Testing alerts")
    @Story("Check verify alerts")
    @Feature("Checking the functionality of various types of alerts")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demoqa.com/alerts")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-124")
    @Step("Checking alerts on the page")
    void alertTest(){
        importHelpers.getBrowserManager().openURL("https://demoqa.com/alerts");

        webElementActions.click(demoqaPages.getAlertPage().alertButton);
        importHelpers.getAlertHelper().acceptAlert();

        webElementActions.scrollToElement(demoqaPages.getAlertPage().timerAlertButton);
        webElementActions.click(demoqaPages.getAlertPage().timerAlertButton);
        importHelpers.getAlertHelper().acceptAlert();

        webElementActions.click(demoqaPages.getAlertPage().confirmButton);
        importHelpers.getAlertHelper().acceptAlert();
        Assert.assertEquals("You selected Ok", demoqaPages.getAlertPage().confirmResult.getText());

        String randomName = randomUtils.generateAlertName();
        webElementActions.click(demoqaPages.getAlertPage().promtButton);
        importHelpers.getAlertHelper().sandKeysAlert(randomName);
        importHelpers.getAlertHelper().acceptAlert();
        String actualResult = webElementActions.getTextFromElement(demoqaPages.getAlertPage().promptResult);
        String expectedText = "You entered " + randomName;
        Assert.assertEquals(actualResult, expectedText);
    }
}
