package pl.sda.j133.demo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.j133.demo.component.StudentBirthYearComponent;
import pl.sda.j133.demo.model.Student;
import pl.sda.j133.demo.repository.StudentDao;

import java.util.List;
import java.util.Optional;

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
}
