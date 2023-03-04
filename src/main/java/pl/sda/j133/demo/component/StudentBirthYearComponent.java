package pl.sda.j133.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.sda.j133.demo.controller.StudentController;
import pl.sda.j133.demo.model.Student;

import java.time.LocalDate;

// @Component
//      @Controller @RestController
//      @Service @Repository
//      @Configuration

@Slf4j
@Component
public class StudentBirthYearComponent {

    public int calculateBirthYear(Student student) {
        int year = LocalDate.now().getYear();
        return year - student.getWiek();
    }
}
