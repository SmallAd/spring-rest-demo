package testgroup.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author smallad
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentErrorResponce {
    private int status;
    private String message;
    private long timeStamp;
}
