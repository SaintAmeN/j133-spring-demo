package pl.sda.j133.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.j133.demo.model.Student;

// CRUD
// create (save)
// read (findById, findAll)
// update (save)
// delete (delete, deleteById)
// exists
@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

}
