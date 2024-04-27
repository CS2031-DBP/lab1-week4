package dbp.week4.lab1.course.infrastructure;

import dbp.week4.lab1.AbstractContainerBaseTest;
import dbp.week4.lab1.Course.domain.Course;
import dbp.week4.lab1.Course.infrastructure.CourseRepository;
import dbp.week4.lab1.Teacher.domain.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryTest extends AbstractContainerBaseTest {
    @Autowired
    CourseRepository repository;

    @Autowired
    TestEntityManager entityManager;

    Course course1;
    Course course2;
    Course course3;

    Teacher teacher1;

    Teacher teacher2;

    Teacher teacher3;

    @BeforeEach
    public void setUp() {
        course1 = new Course("Desarrollo Basado en Plataformas", 3, 6);
        teacher1 = new Teacher("Jorge", "Rios", 20.0, "jriosa@utec.edu.pe", LocalDate.of(1996, 1, 29));
        course1.setTeacher(teacher1);
        course2 = new Course("Arte y Tecnología", 2, 4);
        teacher2 = new Teacher("John", "Doe", 20.0, "jdoe@utec.edu.pe", LocalDate.of(1996, 1, 29));
        course2.setTeacher(teacher2);
        course3 = new Course("Ética", 3, 4);
        teacher3 = new Teacher("Carolina", "Giraldo", 20.0, "cgiraldo@utec.edu.pe", LocalDate.of(1996, 1, 29));
        course3.setTeacher(teacher3);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);
        entityManager.persist(course1);
        entityManager.persist(course2);
        entityManager.persist(course3);
        entityManager.flush();
    }

    @Test
    void shouldFindByTeacherId() {
        List<Course> courses = repository.findByTeacherId(teacher1.getId());

        assertNotNull(courses);
        assertEquals(1, courses.size());
        assertTrue(courses.stream().allMatch(course -> course.getTeacher().getFirstName().equals("Jorge")));
    }

    @Test
    void shouldNotFindByTeacherId() {
        List<Course> courses = repository.findByTeacherId(teacher2.getId());

        assertNotNull(courses);
        assertEquals(1, courses.size());
        assertTrue(courses.stream().noneMatch(course -> course.getTeacher().getFirstName().equals("Carolina")));
    }

    @Test
    void shouldDelete() {
        repository.deleteById(course1.getId());

        assertTrue(repository.findById(course1.getId()).isEmpty());
    }
}
