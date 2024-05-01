package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.DepartmentRequestDto;
import com.example.courseregistrationsystem.models.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface DepartmentService {
    Department getDepartment(@PathVariable Long id);
    Department addDepartment(@RequestBody DepartmentRequestDto requestDto);
    Department updateDepartment(@RequestBody DepartmentRequestDto requestDto);
    String deleteDepartment(Long id);
}
