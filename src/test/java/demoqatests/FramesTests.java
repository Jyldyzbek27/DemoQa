package demoqatests;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class FramesTests extends BaseTest {

    @Test
    @Description("Testing frame functionality on DemoQA")
    @Epic("Frame Functionality")
    @Story("Interact with different frames and retrieve text")
    @Feature("Frames")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://demoqa.com/frames")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-350")
    @Step("Switch to different frames and retrieve text from elements")
    void testFrames() {
        importHelpers.getBrowserManager().openURL("https://demoqa.com/frames");
        importHelpers.getIFrameHelper().switchToIframe(demoqaPages.getFramesPage().frame1);
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading));

        importHelpers.getIFrameHelper().switchToDefaultFrame();
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().textCenter));

        importHelpers.getIFrameHelper().switchToFrameByIndex(2);
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading));
    }
}
