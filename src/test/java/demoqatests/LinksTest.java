package demoqatests;
import demoqa.drivers.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LinksTest extends BaseTest {

    @Test(groups = {"UI", "DN-06"})
    @Description("Testing links and comparing messages")
    @Epic("Testing the 'Elements' section")
    @Story("Check the functionality of links in the 'Elements' section")
    @Feature("Automation of link navigation and response comparison")
    @Owner("Jyldyzbek")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demoqa.com/links")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-123")
    @Step("Check the links page")
    public void testLinkPage() {
        importHelpers.getBrowserManager().openURL("https://demoqa.com/links");

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        Wait<WebDriver> fluentWait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().homeLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().homeLink);

        importHelpers.getWindowHelper().switchToWindow(1);
        DriverManager.getDriver().close();

        importHelpers.getWindowHelper().switchToWindow(0);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().dynamicHomeLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().dynamicHomeLink);

        importHelpers.getWindowHelper().switchToWindow(1);
        DriverManager.getDriver().close();

        importHelpers.getWindowHelper().switchToWindow(0);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().createdLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().createdLink);
        webElementActions.waitElementToBeVisible(demoqaPages.getLinkPage().linkResponse);
        String createdMessage = webElementActions.getTextFromElement(demoqaPages.getLinkPage().linkResponse);
        String actualCreatedMessage = "Link has responded with staus 201 and status text Created";
        Assert.assertEquals(actualCreatedMessage, createdMessage);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().noContentLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().noContentLink);
        webElementActions.waitElementToBeVisible(demoqaPages.getLinkPage().linkResponse);
        importHelpers.getWait().until(ExpectedConditions.textToBePresentInElement(demoqaPages.getLinkPage().linkResponse, "Link has responded with staus 204 and status text No Content"));
        String actualNoContentMessage = webElementActions.getTextFromElement(demoqaPages.getLinkPage().linkResponse);
        String noContentMessage = "Link has responded with staus 204 and status text No Content";
        Assert.assertEquals(actualNoContentMessage, noContentMessage);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().movedLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().movedLink);
        webElementActions.waitElementToBeVisible(demoqaPages.getLinkPage().linkResponse);
        importHelpers.getWait().until(ExpectedConditions.textToBePresentInElement(demoqaPages.getLinkPage().linkResponse, "Link has responded with staus 301 and status text Moved Permanently"));
        String actualMovedLinkMessage = webElementActions.getTextFromElement(demoqaPages.getLinkPage().linkResponse);
        String movedLinkMessage = "Link has responded with staus 301 and status text Moved Permanently";
        Assert.assertEquals(actualMovedLinkMessage, movedLinkMessage);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().badRequestLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().badRequestLink);
        webElementActions.waitElementToBeVisible(demoqaPages.getLinkPage().linkResponse);
        importHelpers.getWait().until(ExpectedConditions.textToBePresentInElement(demoqaPages.getLinkPage().linkResponse, "Link has responded with staus 400 and status text Bad Request"));
        String actualBadRequestLinkMessage = webElementActions.getTextFromElement(demoqaPages.getLinkPage().linkResponse);
        String badRequestLinkMessage = "Link has responded with staus 400 and status text Bad Request";
        Assert.assertEquals(actualBadRequestLinkMessage, badRequestLinkMessage);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().unauthorizedLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().unauthorizedLink);
        webElementActions.waitElementToBeVisible(demoqaPages.getLinkPage().linkResponse);
        importHelpers.getWait().until(ExpectedConditions.textToBePresentInElement(demoqaPages.getLinkPage().linkResponse, "Link has responded with staus 401 and status text Unauthorized"));
        String actualUnauthorizedLinkMessage = webElementActions.getTextFromElement(demoqaPages.getLinkPage().linkResponse);
        String unauthorizedLinkMessage = "Link has responded with staus 401 and status text Unauthorized";
        Assert.assertEquals(actualUnauthorizedLinkMessage, unauthorizedLinkMessage);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().forbiddenLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().forbiddenLink);
        webElementActions.waitElementToBeVisible(demoqaPages.getLinkPage().linkResponse);
        importHelpers.getWait().until(ExpectedConditions.textToBePresentInElement(demoqaPages.getLinkPage().linkResponse, "Link has responded with staus 403 and status text Forbidden"));
        String actualForbiddenLinkMessage = webElementActions.getTextFromElement(demoqaPages.getLinkPage().linkResponse);
        String forbiddenLinkMessage = "Link has responded with staus 403 and status text Forbidden";
        Assert.assertEquals(actualForbiddenLinkMessage, forbiddenLinkMessage);

        fluentWait.until(ExpectedConditions.elementToBeClickable(demoqaPages.getLinkPage().notFoundLink));
        js.executeScript("arguments[0].click();", demoqaPages.getLinkPage().notFoundLink);
        webElementActions.waitElementToBeVisible(demoqaPages.getLinkPage().linkResponse);
        importHelpers.getWait().until(ExpectedConditions.textToBePresentInElement(demoqaPages.getLinkPage().linkResponse, "Link has responded with staus 404 and status text Not Found"));
        String actualFoundLinkMessage = webElementActions.getTextFromElement(demoqaPages.getLinkPage().linkResponse);
        String foundLinkMessage = "Link has responded with staus 404 and status text Not Found";
        Assert.assertEquals(actualFoundLinkMessage, foundLinkMessage);


    }
}

