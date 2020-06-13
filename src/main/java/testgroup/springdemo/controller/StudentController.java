package testgroup.springdemo.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testgroup.springdemo.exception.StudentNotFoundException;
import testgroup.springdemo.model.Student;
import testgroup.springdemo.model.StudentErrorResponce;

/**
 *
 * @author smallad
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("aaa", "111"));
        students.add(new Student("bbbb", "2222"));
        students.add(new Student("ccccc", "33333"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
    
    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if(studentId < 0 || studentId >= students.size())
            throw new StudentNotFoundException("Student id not found - " + studentId);
        return students.get(studentId);
    }
    
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
