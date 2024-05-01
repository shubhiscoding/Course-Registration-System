package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DepartmentResponseDto {
    private Long departmentId;
    private String name;
    private List<Course> courses;
}
