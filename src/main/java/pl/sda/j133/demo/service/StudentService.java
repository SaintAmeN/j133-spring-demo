package pl.sda.j133.demo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.j133.demo.component.StudentBirthYearComponent;
import pl.sda.j133.demo.model.Student;
import pl.sda.j133.demo.model.dto.CreateStudentRequest;
import pl.sda.j133.demo.model.dto.UpdateStudentRequest;
import pl.sda.j133.demo.model.dto.UpdateStudentResponse;
import pl.sda.j133.demo.repository.StudentDao;

import java.util.List;

@Slf4j
@Service
public class StudentService {
    private StudentDao studentDao;
    private StudentBirthYearComponent birthYearComponent;

    public StudentService(StudentDao studentDao, StudentBirthYearComponent birthYearComponent) {
        this.studentDao = studentDao;
        this.birthYearComponent = birthYearComponent;
    }

    public List<Student> getAll() {
        return studentDao.findAll();
    }

    public int getBirthYearOfStudentWithId(Long studentId) {
        Student student = studentDao.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono studenta o id " + studentId));

        return birthYearComponent.calculateBirthYear(student);
    }

//    public int getBirthYearOfStudentWithId(Long studentId) {
//        Optional<Student> studentOptional = studentDao.findById(studentId);
//        if (studentOptional.isPresent()) {
//            Student student = studentOptional.get();
//
//            return birthYearComponent.calculateBirthYear(student);
//        }
//        throw new EntityNotFoundException("Nie znaleziono studenta o id " + studentId);
//    }

    public void delete(Long studentId) {
        studentDao.deleteById(studentId);
    }

    public Student findById(Long studentId) {
        return studentDao.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono studenta o id " + studentId));
    }

    public void createStudent(CreateStudentRequest request) {
//        Student student = new Student(null, request.getFirstName(), request.getLastName(), request.getAge());
        Student student = Student.builder()
                .imie(request.getFirstName())
                .nazwisko(request.getLastName())
                .wiek(request.getAge())
                .build();

        studentDao.save(student);
    }

    public UpdateStudentResponse update(Long studentId, UpdateStudentRequest request) {
        Student student = studentDao.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono studenta o id " + studentId));

        // etap Update
        if (request.getFirstName() != null) {
            student.setImie(request.getFirstName());
        }
        
//        Gdyby??my pozwalali edytowa?? nazwisko, to dodali by??my kolejny if
//        if (request.getLastName() != null) {
//            student.setNazwisko(request.getLastName());
//        }
//        Gdyby??my pozwalali edytowa?? wiek, to dodali by??my kolejny if
//        if (request.getAge() != null) {
//            student.setWiek(request.getAge());
//        }
        
        // etap zapisz aktualizowany obiekt, metoda save zwraca wynik po aktualizacji
        student = studentDao.save(student);

        // zwr???? response, nie studenta (nie entity!)
        return studentToStudentResponse(student);
    }

    private UpdateStudentResponse studentToStudentResponse(Student student) {
        return new UpdateStudentResponse(
                student.getId(),
                student.getImie(),
                student.getNazwisko(),
                student.getWiek()
        );
    }
}

