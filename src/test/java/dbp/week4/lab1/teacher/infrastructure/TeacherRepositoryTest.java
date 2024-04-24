package dbp.week4.lab1.teacher.infrastructure;

import dbp.week4.lab1.AbstractContainerBaseTest;
import dbp.week4.lab1.Teacher.domain.Teacher;
import dbp.week4.lab1.Teacher.infrastructure.TeacherRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeacherRepositoryTest extends AbstractContainerBaseTest {
    @Autowired
    TeacherRepository repository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void shouldThrowExceptionByUniqueEmail() {
        Teacher teacher1 = new Teacher("Jorge", "Rios", 20.0, "jriosa@utec.edu.pe", LocalDate.of(1996, 1, 29));
        Teacher teacher2 = new Teacher("John", "Doe", 20.0, "jriosa@utec.edu.pe", LocalDate.of(1996, 1, 29));

        entityManager.persistAndFlush(teacher1);

        assertThrows(ConstraintViolationException.class, () -> {
            entityManager.persistAndFlush(teacher2);
        });
    }
}
