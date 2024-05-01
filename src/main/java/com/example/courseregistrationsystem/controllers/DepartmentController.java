package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.DepartmentRequestDto;
import com.example.courseregistrationsystem.dtos.DepartmentResponseDto;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public DepartmentResponseDto getDepartment(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/")
    public DepartmentResponseDto addDepartment(@RequestBody DepartmentRequestDto requestDto) {
        return null;
    }

    @PutMapping("/")
    public DepartmentResponseDto updateDepartment(@RequestBody DepartmentRequestDto requestDto) {
        return null;
    }

    @DeleteMapping("/")
    public String deleteDepartment(@RequestBody Department department) {
        return null;
    }

}
