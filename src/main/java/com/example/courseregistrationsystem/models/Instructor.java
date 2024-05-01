package com.example.courseregistrationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Instructor {
    @Id
    private Long instructorId;
    private String name;
    private String title;
    @ManyToOne
    private Department department;
    @OneToMany
    private List<Course> courses;
}
