package demoqa.enums;
import lombok.Getter;

@Getter
public enum OldStyleSelectMenuValues {

    GREEN("Green"),
    RED("Red"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    PURPLE("Purple"),
    BLACK("Black");

    private final String color;

    OldStyleSelectMenuValues(String color) {
        this.color = color;
    }
}
