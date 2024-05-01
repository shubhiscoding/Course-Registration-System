package com.example.courseregistrationsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

