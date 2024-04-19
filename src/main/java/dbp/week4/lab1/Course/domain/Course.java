package dbp.week4.lab1.Course.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import dbp.week4.lab1.Student.domain.Student;
import dbp.week4.lab1.Teacher.domain.Teacher;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer creditNumber;

    private String description;

    @NonNull
    private Integer weeklyHours;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}

