package demoqa.utils;
import com.github.javafaker.Faker;
import demoqa.enities.TextBoxEntity;

public class RandomUtils {

    Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public String generateAlertName() {
        return faker.name().firstName();
    }

}
