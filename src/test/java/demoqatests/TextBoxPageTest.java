package demoqatests;
import demoqa.data.MockDataGenerator;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxPageTest extends BaseTest {

    @Test
    @Description("Testing the functionality of the text box on DemoQA")
    @Epic("Text Box Functionality")
    @Story("Fill up the text box form and verify input values")
    @Feature("Text Box")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demoqa.com/text-box")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-330")
    @Step("Fill out the form and verify the name and email input fields")
    void testTextBoxPage() {
        importHelpers.getBrowserManager().openURL("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().fillUpTextBoxForm(randomUtils.generateRandomTextBoxEntity());

        webElementActions.waitElementToBeVisible(demoqaPages.getTextBoxPage().actualName);
        String actualFullNameText = webElementActions.getTextFromElement(demoqaPages.getTextBoxPage().actualName);
        String actualNameText = actualFullNameText.split(":")[1].trim();
        String expectedNameText = demoqaPages.getTextBoxPage().inputUserName.getAttribute("value");
        Assert.assertEquals(actualNameText, expectedNameText);
        System.out.println("Actual name input: " + actualNameText);
        System.out.println("Expected name value " + expectedNameText);

        webElementActions.waitElementToBeVisible(demoqaPages.getTextBoxPage().actualEmail);
        String actualFullEmailText = webElementActions.getTextFromElement(demoqaPages.getTextBoxPage().actualEmail);
        String actualEmailText = actualFullEmailText.split(":")[1].trim();
        String expectedEmailText = demoqaPages.getTextBoxPage().inputUserEmail.getAttribute("value");
        Assert.assertEquals(actualEmailText, expectedEmailText);

        webElementActions.waitElementToBeVisible(demoqaPages.getTextBoxPage().actualCurrentAddress);
        String actualFullCurrentAddressText = webElementActions.getTextFromElement(demoqaPages.getTextBoxPage().actualCurrentAddress);
        String actualCurrentAddressText = actualFullCurrentAddressText.split(":")[1].trim();
        String expectedCurrentAddressText = demoqaPages.getTextBoxPage().inputCurrentAddress.getAttribute("value");
        Assert.assertEquals(actualCurrentAddressText, expectedCurrentAddressText);

        webElementActions.waitElementToBeVisible(demoqaPages.getTextBoxPage().actualPermanentAddress);
        String actualFullPermanentAddressText = webElementActions.getTextFromElement(demoqaPages.getTextBoxPage().actualPermanentAddress);
        String actualPermanentAddressText = actualFullPermanentAddressText.split(":")[1].trim();
        String expectedPermanentAddressText = demoqaPages.getTextBoxPage().inputPermanentAddress.getAttribute("value");
        Assert.assertEquals(actualPermanentAddressText, expectedPermanentAddressText);
    }

    @Test
    @Description("Testing the text box functionality on DemoQA")
    @Epic("Text Box Functionality")
    @Story("Fill the text box form with random data")
    @Feature("Text Box")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://demoqa.com/text-box")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-340")
    @Step("Fill out the text box form with random data")
    void testTextBoxPage2(){
        importHelpers.getBrowserManager().openURL("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().fillUpTextBoxForm(MockDataGenerator.randomTextBox());

    }
}