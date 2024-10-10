package demoqa.data;
import com.github.javafaker.Faker;
import demoqa.enities.TextBoxEntity;
import demoqa.enities.WebTablesEntity;

import java.util.Random;


public class MockDataGenerator {

    private static Faker faker = new Faker();
    private static Random random = new Random();

    private static String randomFullName() {
        return faker.name().fullName();
    }

    private static String randomEmail() {
        return faker.internet().emailAddress();
    }

    private static String randomAddress() {
        return faker.name().fullName();
    }

    private static String randomFirstName() {
        return faker.name().firstName();
    }

    private static String randomLastName() {
        return faker.name().lastName();
    }

    private static String randomSalary() {
        int randomNumber = random.nextInt(1001) + 1000;
        return String.valueOf(randomNumber);
    }

    private static String randomAge() {
        int randomNumber = random.nextInt(18) + 99;
        return String.valueOf(randomNumber);
    }

    private static String randomDepartment(){
        return faker.company().profession();
    }


    public static TextBoxEntity randomTextBox() {
        String fullName = randomFullName();
        String email = randomEmail();
        String currentAddress = randomAddress();
        String permanentAddress = randomAddress();
        TextBoxEntity textBoxEntity = new TextBoxEntity(fullName, email, currentAddress, permanentAddress);
        return textBoxEntity;
    }

    public static WebTablesEntity randomWebTableData(){
        String firstName = randomFirstName();
        String lastName = randomLastName();
        String email = randomEmail();
        String age = randomAge();
        String salary = randomSalary();
        String department = randomDepartment();
        WebTablesEntity webTablesEntity = new WebTablesEntity(firstName, lastName, email, age, salary, department);
        return webTablesEntity;
    }
}
