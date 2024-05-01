package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id) {
        return null;
    }

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department) {
        return null;
    }

    @PutMapping("/")
    public Department updateDepartment(@RequestBody Department department) {
        return null;
    }

    @DeleteMapping("/")
    public String deleteDepartment(@RequestBody Department department) {
        return null;
    }

}
