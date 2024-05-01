package com.example.courseregistrationsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Department {
    @Id
    private Long departmentId;

    private String name;

    @OneToMany
    private List<Course> courses;

}