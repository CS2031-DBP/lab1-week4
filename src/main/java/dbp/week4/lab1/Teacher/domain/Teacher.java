package dbp.week4.lab1.Teacher.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dbp.week4.lab1.Course.domain.Course;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private Double hourlyWage;

    @NonNull
    @Column(unique = true)
    private String email;

    @NonNull
    private LocalDate birthday;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Course> courses;
}

