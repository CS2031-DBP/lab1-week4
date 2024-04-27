package dbp.week4.lab1.Course.infrastructure;

import dbp.week4.lab1.Course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTeacherId(Long teacherId);

    List<Course> findByStudentsId(Long studentId);
}
