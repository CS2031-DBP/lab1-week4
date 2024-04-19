package dbp.week4.lab1.Teacher.domain;

import dbp.week4.lab1.Course.domain.Course;
import lombok.Value;

import java.util.List;

@Value
public class TeacherPreviewDTO {
    String lastName;
    List<Course> courses;
}