package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InstructorRequestDto {
    private Long instructorId;
    private String name;
    private String title;
    private Long  departmentId;
    private String adminUsername;
    private String password;
}
