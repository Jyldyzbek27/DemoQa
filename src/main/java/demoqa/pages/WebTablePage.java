package demoqa.pages;
import demoqa.enities.WebTablesEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(id = "firstName")
    public WebElement inputFirstName;

    @FindBy(id = "lastName")
    public WebElement inputLastName;

    @FindBy(id = "userEmail")
    public WebElement inputUserEmail;

    @FindBy(id = "age")
    public WebElement inputAge;

    @FindBy(id = "salary")
    public WebElement inputSalary;

    @FindBy(id = "department")
    public WebElement inputDepartment;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @Step("Fill up web table form")
    public WebTablePage fillUpWebTable(WebTablesEntity webTablesEntity){
        webElementActions.click(addNewRecordButton)
                .input(inputFirstName, webTablesEntity.getFirstName())
                .input(inputLastName, webTablesEntity.getLastName())
                .input(inputUserEmail, webTablesEntity.getEmail())
                .input(inputAge, webTablesEntity.getAge())
                .input(inputSalary, webTablesEntity.getSalary())
                .input(inputDepartment, webTablesEntity.getDepartment())
                .click(submitBtn);
        return this;
    }
}
