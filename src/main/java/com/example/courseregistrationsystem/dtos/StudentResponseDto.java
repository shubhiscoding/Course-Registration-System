package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class StudentResponseDto {
    private Long studentId;
    private String name;
    private String email;
    private Date dateOfEnrollment;
    private List<Course> courses;
}
