package dbp.week4.lab1.Course.infrastructure;

import dbp.week4.lab1.Course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Iterable<Course> findByTeacherId(Long teacherId);

    Iterable<Course> findByStudentsId(Long studentId);
}
