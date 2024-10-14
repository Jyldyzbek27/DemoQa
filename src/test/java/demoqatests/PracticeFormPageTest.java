package demoqatests;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeFormPageTest extends BaseTest {


    @Test(groups = {"API", "DN-001"})
    @Description("Проверка заполнения формы")
    @Epic("Тестирование формы заполнения")
    @Story("Проверка функциональности формы с данными пользователя")
    @Feature("Автоматизация заполнения формы и валидация данных")
    @Owner("Жылдызбек")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://demoqa.com/automation-practice-form")
    @TmsLink("https://kubatbekovvv270919.atlassian.net/wiki/spaces/fgPdWRaO6KzO/pages/491525/-")
    @Issue("JIRA-126") // Укажите актуальный идентификатор задачи
    void testPracticeForm(){
        importHelpers.getBrowserManager().openURL("https://demoqa.com/automation-practice-form");
        demoqaPages.getPracticeFormPage().fillUpPracticeFormPage();

        String firstNameInputValue = demoqaPages.getPracticeFormPage().firstNameInput.getAttribute("value");
        String lastNameInputValue = demoqaPages.getPracticeFormPage().lastNameInput.getAttribute("value");
        String expectedFullName = firstNameInputValue + " " + lastNameInputValue;
        String actualFullNameForAssert = demoqaPages.getPracticeFormPage().actualFullNameText.getText();
        Assert.assertEquals(actualFullNameForAssert, expectedFullName);

        String expectedEmailValue = demoqaPages.getPracticeFormPage().userEmailInput.getAttribute("value");
        String actualEmailForAssert = demoqaPages.getPracticeFormPage().actualEmailText.getText();
        Assert.assertEquals(actualEmailForAssert, expectedEmailValue);

        String expectedGenderValue = demoqaPages.getPracticeFormPage().getSelectedGender();
        String actualGenderForAssert = demoqaPages.getPracticeFormPage().actualGenderText.getText();
        Assert.assertEquals(actualGenderForAssert, expectedGenderValue);

        String expectedUserNumberValue = demoqaPages.getPracticeFormPage().userNumberInput.getAttribute("value");
        String actualUserNumberForAssert = demoqaPages.getPracticeFormPage().actualUserNumberText.getText();
        Assert.assertEquals(actualUserNumberForAssert, expectedUserNumberValue);

        String expectedDateOfBirthValue = demoqaPages.getPracticeFormPage().getDateOfBirth();
        String actualDateOfBirthForAssert = demoqaPages.getPracticeFormPage().actualDateOfBirthText.getText();
        Assert.assertEquals(actualDateOfBirthForAssert, expectedDateOfBirthValue);

        String expectedHobbiesValue = demoqaPages.getPracticeFormPage().getSelectedHobbies();
        String actualHobbiesForAssert = demoqaPages.getPracticeFormPage().actualHobbiesText.getText();
        Assert.assertEquals(actualHobbiesForAssert, expectedHobbiesValue);

        String expectedPictureName = "Granit Djaka.jpeg";
        String actualPictureNameForAssert = demoqaPages.getPracticeFormPage().actualPicture.getText();
        Assert.assertEquals(actualPictureNameForAssert, expectedPictureName);

        String expectedAddressValue = demoqaPages.getPracticeFormPage().currentAddressInput.getAttribute("value");
        String actualAddressForAssert = demoqaPages.getPracticeFormPage().actualAddressText.getText();
        Assert.assertEquals(actualAddressForAssert, expectedAddressValue);

    }
}
