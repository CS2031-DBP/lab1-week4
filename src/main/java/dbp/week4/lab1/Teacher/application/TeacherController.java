package dbp.week4.lab1.Teacher.application;

import dbp.week4.lab1.Teacher.domain.Teacher;
import dbp.week4.lab1.Teacher.domain.TeacherPreviewDTO;
import dbp.week4.lab1.Teacher.domain.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok(createdTeacher);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Teacher>> getAllTeachers() {
        Iterable<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        boolean deleted = teacherService.deleteTeacher(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        return updatedTeacher != null ? ResponseEntity.ok(updatedTeacher) : ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Teacher> getTeacherByEmail(@PathVariable String email) {
        Teacher teacher = teacherService.getTeacherByEmail(email);
        return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();
    }

    @GetMapping("/firstname/{firstName}")
    public ResponseEntity<Teacher> getTeacherByFirstName(@PathVariable String firstName) {
        Teacher teacher = teacherService.getTeacherByFirstName(firstName);
        return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<Teacher> getTeacherByLastName(@PathVariable String lastName) {
        Teacher teacher = teacherService.getTeacherByLastName(lastName);
        return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();
    }

    @GetMapping("/birthday/{birthday}")
    public ResponseEntity<Teacher> getTeacherByBirthday(@PathVariable LocalDate birthday) {
        Teacher teacher = teacherService.getTeacherByBirthday(birthday);
        return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/preview")
    public ResponseEntity<TeacherPreviewDTO> getTeacherPreview(@PathVariable Long id) {
        TeacherPreviewDTO teacherPreview = teacherService.getTeacherPreview(id);
        return teacherPreview != null ? ResponseEntity.ok(teacherPreview) : ResponseEntity.notFound().build();
    }
}
