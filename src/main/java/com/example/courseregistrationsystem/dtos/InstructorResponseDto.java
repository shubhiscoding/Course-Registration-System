package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class InstructorResponseDto {
    private Long instructorId;
    private String name;
    private String title;
    private Department department;
    private List<Course> courses;
}
