package testgroup.springdemo.controller;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import testgroup.springdemo.exception.StudentNotFoundException;
import testgroup.springdemo.model.StudentErrorResponce;

/**
 *
 * @author smallad
 */
@ControllerAdvice
public class SudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponce> handleException(StudentNotFoundException exc) {

        StudentErrorResponce error = new StudentErrorResponce();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(Instant.now().getEpochSecond());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponce> handleException(Exception exc) {
        StudentErrorResponce error = new StudentErrorResponce();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(Instant.now().getEpochSecond());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
