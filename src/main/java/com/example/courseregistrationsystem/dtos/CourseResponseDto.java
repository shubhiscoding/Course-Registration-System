package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.models.Student;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class CourseResponseDto {
    private Long courseId;
    private String name;
    private String description;
    private int credits;
    private Department department;
    private List<Student> students;
    private Instructor instructor;

}
