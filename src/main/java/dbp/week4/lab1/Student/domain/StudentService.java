package dbp.week4.lab1.Student.domain;

import dbp.week4.lab1.Student.infrastructure.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent == null) {
            return null;
        }
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBirthday(student.getBirthday());
        existingStudent.setCourses(student.getCourses());
        return studentRepository.save(existingStudent);
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Iterable<Student> getStudentsByCourse(Long courseId) {
        return studentRepository.findByCoursesId(courseId);
    }

}