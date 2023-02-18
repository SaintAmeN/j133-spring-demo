package pl.sda.j133.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.j133.demo.model.Student;
import pl.sda.j133.demo.repository.StudentDao;

import java.util.List;

@Slf4j
@Service
public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAll() {
        return studentDao.findAll();
    }

    public void delete(Long studentId) {
        studentDao.deleteById(studentId);
    }
}
