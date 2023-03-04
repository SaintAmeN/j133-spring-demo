package pl.sda.j133.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.j133.demo.model.Student;
import pl.sda.j133.demo.model.dto.CreateStudentRequest;
import pl.sda.j133.demo.model.dto.UpdateStudentRequest;
import pl.sda.j133.demo.model.dto.UpdateStudentResponse;
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
    // http://localhost:8080/student/birthyear?sId=3
    @GetMapping("/birthyear")
    @ResponseStatus(HttpStatus.OK)
    public int getBirthYear(@RequestParam Long sId) {
        log.info("Ktoś zapytał o rok urodzenia studenta o id: {}", sId);
        return studentService.getBirthYearOfStudentWithId(sId);
    }

    // READ
    // http://localhost:8080/student
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentList() {
        log.info("Ktoś zapytał o listę studentów.");
        return studentService.getAll();
    }

    // READ
    // http://localhost:8080/student/byId?studentId=1
    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentWithId(@RequestParam Long studentId) {
        log.info("Ktoś zapytał o studenta z identyfikatorem: {}", studentId);
        return studentService.findById(studentId);
    }

    // READ
    // http://localhost:8080/student/1
    @GetMapping("/{identyfikator}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable Long identyfikator) {
        log.info("Ktoś zapytał o studenta z identyfikatorem: {}", identyfikator);
        return studentService.findById(identyfikator);
    }

    // DELETE
    // ADRES BAZOWY: http://localhost:8080/student
    //
    // http://localhost:8080/student?id=1
    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@RequestParam Long stid) {
        log.info("Ktoś poprosił o usunięcie studenta o id: {}", stid);
        studentService.delete(stid);
    }

    // CREATE
    // http://localhost:8080/student
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody CreateStudentRequest request) {
        log.info("Wywołano dodanie studenta: {}", request);
        studentService.createStudent(request);
    }

    // UPDATE
    @PatchMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateStudentResponse updateStudent(@PathVariable Long studentId, @RequestBody UpdateStudentRequest request) {
        log.info("Wywołano aktualizację studenta o id: {}, dane: {}", studentId, request);
        return studentService.update(studentId, request);
    }
}
