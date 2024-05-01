package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentRequestDto {
    private Long departmentId;
    private String name;
    private String adminUsername;
    private String password;
}
