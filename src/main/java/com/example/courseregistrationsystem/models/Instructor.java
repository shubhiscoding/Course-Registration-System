package com.example.courseregistrationsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;
    private String name;
    private String title;
    @ManyToOne
    private Department department;
    @OneToMany
    private List<Course> courses;
}
