package dbp.week4.lab1;

import dbp.week4.lab1.Course.application.CourseController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Lab1ApplicationTests {
    @Autowired
    CourseController courseController;

    @Test
    void contextLoads() {
        assertThat(courseController).isNotNull();
    }

}
