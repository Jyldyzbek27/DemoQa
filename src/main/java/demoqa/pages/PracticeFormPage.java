package demoqa.pages;
import demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;


/**
 * Класс для работы с формой на странице "Practice Form".
 * Включает методы для случайного выбора значений полей формы и заполнения её с использованием Faker.
 */
public class PracticeFormPage extends BasePage {


    private String selectedGenderText;
    private String selectedHobbiesText;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(id = "userNumber")
    public WebElement userNumberInput;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//label[(text())='Male']")
    public WebElement choiceMaleBtn;

    @FindBy(xpath = "//label[(text())='Female']")
    public WebElement choiceFemaleBtn;

    @FindBy(xpath = "//label[(text())='Other']")
    public WebElement choiceOtherBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement choiceSportBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    public WebElement choiceReadingBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    public WebElement choiceMusicBtn;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    public WebElement actualFullNameText;

    @FindBy(xpath = "//table/tbody/tr[2]/td[2]")
    public WebElement actualEmailText;

    @FindBy(xpath = "//table/tbody/tr[3]/td[2]")
    public WebElement actualGenderText;

    @FindBy(xpath = "//table/tbody/tr[4]/td[2]")
    public WebElement actualUserNumberText;

    @FindBy(xpath = "//table/tbody/tr[5]/td[2]")
    public WebElement actualDateOfBirthText;

    @FindBy(xpath = "//table/tbody/tr[6]/td[2]")
    public WebElement actualSubjectText;

    @FindBy(xpath = "//table/tbody/tr[7]/td[2]")
    public WebElement actualHobbiesText;

    @FindBy(xpath = "//table/tbody/tr[8]/td[2]")
    public WebElement actualPicture;

    @FindBy(xpath = "//table/tbody/tr[9]/td[2]")
    public WebElement actualAddressText;

    @FindBy(xpath = "//table/tbody/tr[10]/td[2]")
    public WebElement actualStateAndCityText;


    /**
     * Метод для случайного выбора пола (мужской, женский, другой).
     * Выполняет клик через JavascriptExecutor.
     */
    public void randomChoiceGender() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement[] genderOptions = {choiceMaleBtn, choiceFemaleBtn, choiceOtherBtn};
        int randomIndex = random.nextInt(genderOptions.length);
        WebElement selectedGenderOption = genderOptions[randomIndex];
        js.executeScript("arguments[0].click();", selectedGenderOption);

        selectedGenderText = selectedGenderOption.getAttribute("value");
        if (selectedGenderText == null || selectedGenderText.isEmpty()) {
            selectedGenderText = selectedGenderOption.getText();
        }
    }

    public String getSelectedGender() {
        return selectedGenderText;
    }

    public String getDateOfBirth() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        return currentDate.format(formatter);
    }

    /**
     * Метод для случайного выбора хобби (спорт, чтение, музыка).
     * Выполняет клик через JavascriptExecutor для избежания возможных проблем с WebDriver.
     */
    public String randomChoiceHobbies() {
        WebElement[] hobbiesOptions = {choiceSportBtn, choiceReadingBtn, choiceMusicBtn};
        int randomIndex = random.nextInt(hobbiesOptions.length);
        WebElement selectedHobbiesOption = hobbiesOptions[randomIndex];
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", selectedHobbiesOption);
        selectedHobbiesText = selectedHobbiesOption.getText();

        return selectedHobbiesText;
    }

    public String getSelectedHobbies() {
        return selectedHobbiesText;
    }

    /**
     * Метод для случайного выбора предмета из выпадающего списка.
     */
    public void randomChoiceSubject() {
        try {
            String[] letters = {"m", "s", "c"};
            String randomLetter = letters[random.nextInt(letters.length)];
            webElementActions.input(subjectsInput, randomLetter);

            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            List<WebElement> dropDownItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".subjects-auto-complete__option")));

            int randomIndex = random.nextInt(dropDownItems.size());
            WebElement randomItem = dropDownItems.get(randomIndex);

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();", randomItem);
        } catch (NoSuchElementException ignored) {
        }
    }

    /**
     * Метод для выбора случайного штата и города на форме.
     * Выполняет скролл к элементам и использует JavaScript для клика по элементам.
     */
    public void choiceRandomStateAndCity() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

            WebElement stateDropdown = DriverManager.getDriver().findElement(By.xpath("//div[@id='state']"));

            js.executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
            webElementActions.waitElementToBeClickable(stateDropdown);
            webElementActions.click(stateDropdown);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,' css-26l3qy-menu')]")));

            List<WebElement> stateOptions = DriverManager.getDriver().findElements(By.xpath("//div[contains(@class,' css-26l3qy-menu')]"));

            int stateIndex = random.nextInt(stateOptions.size());
            WebElement selectedState = stateOptions.get(stateIndex);
            webElementActions.click(selectedState);

            WebElement cityDropdown = DriverManager.getDriver().findElement(By.xpath("//div[@id='city']"));
            js.executeScript("arguments[0].scrollIntoView(true);", cityDropdown);
            webElementActions.click(cityDropdown);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-11unzgr']")));

            List<WebElement> cityOptions = DriverManager.getDriver().findElements(By.xpath("//div[@class=' css-11unzgr']"));

            int cityIndex = random.nextInt(cityOptions.size());
            WebElement selectedCity = cityOptions.get(cityIndex);
            webElementActions.click(selectedCity);


        } catch (Exception e) {
            System.out.println("Ошибка в методе выбора штата и города: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Метод для заполнения всех полей формы случайными данными и отправки формы.
     * Используются Faker для генерации данных и JavascriptExecutor для кликов и ввода данных.
     */
    public PracticeFormPage fillUpPracticeFormPage() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value=arguments[1];", firstNameInput, faker.name().firstName());
        js.executeScript("arguments[0].value=arguments[1];", lastNameInput, faker.name().lastName());
        js.executeScript("arguments[0].value=arguments[1];", userEmailInput, faker.internet().emailAddress());
        randomChoiceGender();
        js.executeScript("arguments[0].value=arguments[1];", userNumberInput, faker.phoneNumber().subscriberNumber(10));
        randomChoiceSubject();
        randomChoiceHobbies();
        uploadPicture.sendKeys("C://Users//User//IdeaProjects//DemoQA//src//main//resources//Granit Djaka.jpeg");
        js.executeScript("arguments[0].value=arguments[1];", currentAddressInput, faker.address().fullAddress());
        choiceRandomStateAndCity();
        webElementActions.waitElementToBeVisible(submitBtn);
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        js.executeScript("arguments[0].click();", submitBtn);
        //webElementActions.click(element);

        return this;
    }
}
