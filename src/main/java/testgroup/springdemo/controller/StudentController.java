package testgroup.springdemo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testgroup.springdemo.model.Student;

/**
 *
 * @author smallad
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("aaa", "111"));
        students.add(new Student("bbbb", "2222"));
        students.add(new Student("ccccc", "33333"));
        
        return students;
    }
}
