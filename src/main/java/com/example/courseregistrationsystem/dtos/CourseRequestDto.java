package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseRequestDto {
    private Long courseId;
    private String name;
    private String description;
    private int credits;
    private Long departmentId;
    private String adminUsername;
    private String password;
}
