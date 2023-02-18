package pl.sda.j133.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.j133.demo.model.Student;
import pl.sda.j133.demo.service.StudentService;

import java.util.List;
// GET DELETE PATCH POST PUT

@Slf4j
@RestController // Representational state transfer
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // READ
    // http://localhost:8080/student
    @GetMapping("/get")
    public List<Student> getStudentList() {
        log.info("Ktoś zapytał o listę studentów.");
        return studentService.getAll();
    }

    // DELETE
    // ADRES BAZOWY: http://localhost:8080/student
    //
    // http://localhost:8080/student?id=1
    @DeleteMapping()
    public void deleteStudent(@RequestParam Long id) {
        log.info("Ktoś poprosił o usunięcie studenta o id: {}", id);
        studentService.delete(id);
    }
}
