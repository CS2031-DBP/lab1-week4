package dbp.week4.lab1.course.domain;

import dbp.week4.lab1.Course.domain.Course;
import dbp.week4.lab1.Student.domain.Student;
import dbp.week4.lab1.Teacher.domain.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course course;

    Teacher teacher;

    List<Student> students;
    Student student1;
    Student student2;
    Student student3;

    @BeforeEach
    void setUp() {
        teacher = new Teacher("Jorge", "Rios", 20.0, "jriosa@utec.edu.pe", LocalDate.of(1996, 1, 29));
        student1 = new Student("Jorge", "Rios", "jorge.rios.a@utec.edu.pe", LocalDate.of(1996, 1, 29));
        student2 = new Student("John", "Doe", "john.doe@example.com", LocalDate.of(2000, 1, 1));
        student3 = new Student("Carolina", "Giraldo", "carolina.giraldo@example.com", LocalDate.of(1991, 2, 14));
        students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        course = new Course("Arte y Tecnología", 3, 6);
    }

    @Test
    void shouldNotBeNull() {
        assertNotNull(course);
    }

    @Test
    void shouldCreateCourse() {
        assertEquals("Arte y Tecnología", course.getName());
        assertEquals(3, course.getCreditNumber());
        assertEquals(6, course.getWeeklyHours());
    }

    @Test
    void shouldHasATeacher() {
        course.setTeacher(teacher);
        assertNotNull(course.getTeacher());
        assertEquals("Jorge", course.getTeacher().getFirstName());
        assertEquals("Rios", course.getTeacher().getLastName());
        assertEquals(20.00, course.getTeacher().getHourlyWage());
        assertEquals("jriosa@utec.edu.pe", course.getTeacher().getEmail());
        LocalDate date = LocalDate.of(1996, 1, 29);
        assertEquals(date.getYear(), course.getTeacher().getBirthday().getYear());
        assertEquals(date.getMonth(), course.getTeacher().getBirthday().getMonth());
        assertEquals(date.getDayOfMonth(), course.getTeacher().getBirthday().getDayOfMonth());
    }

    @Test
    void shouldHasStudents() {
        course.setStudents(students);
        assertNotNull(course.getStudents());
        assertEquals(3, course.getStudents().size());
    }
}
