package com.example.courseregistrationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Course {
    @Id
    private Long courseId;
    private String name;
    private String description;
    private int credits;
    @ManyToOne
    private Department department;
    @ManyToMany
    private List<Student> students;
    @ManyToOne
    private Instructor instructor;
}

