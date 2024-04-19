package dbp.week4.lab1.Teacher.infrastructure;

import dbp.week4.lab1.Teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByEmail(String email);

    Teacher findByFirstName(String firstName);

    Teacher findByLastName(String lastName);

    Teacher findByBirthday(LocalDate birthday);
}
