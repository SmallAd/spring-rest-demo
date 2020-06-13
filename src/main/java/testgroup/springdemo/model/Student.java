package testgroup.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author smallad
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
//    private int id;
    private String firstName;
    private String lastName;
}
