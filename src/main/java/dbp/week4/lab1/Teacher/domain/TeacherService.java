package dbp.week4.lab1.Teacher.domain;

import dbp.week4.lab1.Teacher.infrastructure.TeacherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public boolean deleteTeacher(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher teacherToUpdate = teacherRepository.findById(id).orElse(null);
        if (teacherToUpdate == null) {
            return null;
        }
        teacherToUpdate.setFirstName(teacher.getFirstName());
        teacherToUpdate.setLastName(teacher.getLastName());
        teacherToUpdate.setHourlyWage(teacher.getHourlyWage());
        teacherToUpdate.setEmail(teacher.getEmail());
        teacherToUpdate.setBirthday(teacher.getBirthday());
        teacherToUpdate.setCourses(teacher.getCourses());
        return teacherRepository.save(teacherToUpdate);
    }

    public Teacher getTeacherByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }

    public Teacher getTeacherByFirstName(String firstName) {
        return teacherRepository.findByFirstName(firstName);
    }

    public Teacher getTeacherByLastName(String lastName) {
        return teacherRepository.findByLastName(lastName);
    }

    public Teacher getTeacherByBirthday(LocalDate birthday) {
        return teacherRepository.findByBirthday(birthday);
    }

    public TeacherPreviewDTO getTeacherPreview(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher == null) {
            return null;
        }
        return new TeacherPreviewDTO(teacher.getLastName(), teacher.getCourses());
    }

}
