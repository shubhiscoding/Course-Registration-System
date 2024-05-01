package com.example.courseregistrationsystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private Long courseId;
    private String name;
    private String description;
    private int credits;
    private Department department;
}

