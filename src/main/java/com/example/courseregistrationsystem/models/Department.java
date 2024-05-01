package com.example.courseregistrationsystem.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Department {

    private Long departmentId;

    private String name;

    private List<Course> courses;

    // Constructors, getters, and setters
}