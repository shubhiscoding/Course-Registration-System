package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.models.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface DepartmentService {
    Department getDepartment(@PathVariable Long id);
    Department addDepartment(@RequestBody Department department);
    Department updateDepartment(@RequestBody Department department);
    String deleteDepartment(@RequestBody Department department);
}
