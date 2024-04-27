package dbp.week4.lab1.Student.infrastructure;

import dbp.week4.lab1.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);
    List<Student> findByCoursesId(Long courseId);
}
