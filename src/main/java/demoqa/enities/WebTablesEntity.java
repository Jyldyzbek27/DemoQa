package demoqa.enities;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class WebTablesEntity {

    String firstName;
    String lastName;
    String email;
    String age;
    String salary;
    String department;

}
