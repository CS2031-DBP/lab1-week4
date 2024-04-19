package dbp.week4.lab1.Course.domain;

import dbp.week4.lab1.Course.infrastructure.CourseRepository;
import dbp.week4.lab1.Student.domain.Student;
import dbp.week4.lab1.Student.infrastructure.StudentRepository;
import dbp.week4.lab1.Teacher.domain.Teacher;
import dbp.week4.lab1.Teacher.infrastructure.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private  StudentRepository studentRepository;
    private  TeacherRepository teacherRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse == null) {
            return null;
        }
        existingCourse.setName(course.getName());
        existingCourse.setTeacher(course.getTeacher());
        existingCourse.setStudents(course.getStudents());
        return courseRepository.save(existingCourse);
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Iterable<Course> getCoursesByTeacher(Long teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }

    public Iterable<Course> getCoursesByStudent(Long studentId) {
        return courseRepository.findByStudentsId(studentId);
    }

    public void addStudentToCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);
        if (course != null && student != null) {
            course.getStudents().add(student);
            courseRepository.save(course);
        }
    }

    public void addTeacherToCourse(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        if (course != null && teacher != null) {
            course.setTeacher(teacher);
            courseRepository.save(course);
        }
    }

}
