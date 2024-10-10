package demoqa.pages;
import demoqa.enities.TextBoxEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class TextBoxPage extends BasePage{

    @FindBy(id = "userName")
    public WebElement inputUserName;

    @FindBy(id = "userEmail")
    public WebElement inputUserEmail;

    @FindBy(id = "currentAddress")
    public WebElement inputCurrentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement inputPermanentAddress;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(id = "name")
    public WebElement actualName;

    @FindBy(id = "email")
    public WebElement actualEmail;

    @FindBy(xpath = "//p[@class='mb-1' and @id='currentAddress']")
    public WebElement actualCurrentAddress;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    public WebElement actualPermanentAddress;




    @Step("Fill up text box form")
    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity){
        webElementActions.input(inputUserName, textBoxEntity.getFullName())
                .input(inputUserEmail, textBoxEntity.getEmail())
                .input(inputCurrentAddress, textBoxEntity.getCurrentAddress())
                .input(inputPermanentAddress, textBoxEntity.getPermanentAddress())
                .click(submitBtn);
        return this;
    }

//    public TextBoxPage inputUserName(String userName) {
//        webElementActions.input(this.userName, userName);
//        return this;
//    }
//
//    public TextBoxPage inputUserEmail(String userEmail) {
//        webElementActions.input(this.userEmail, userEmail);
//        return this;
//    }

//    public TextBoxPage fillTextBoxForm(TextBoxEntity textBoxEntity){
//        inputUserName(textBoxEntity.getFullName())
//                .inputUserEmail(textBoxEntity.getEmail());
//
//    }

}
