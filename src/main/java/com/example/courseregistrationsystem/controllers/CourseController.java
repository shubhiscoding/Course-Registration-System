package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/courses/")
public class CourseController {
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long id) {
        return null;
    }
    @GetMapping
    public List<Course> getAllCourses() {
        return null;
    }

    @GetMapping("/department/{id}")
    public List<Course> getCourseByDepartmentId(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/student/{id}")
    public List<Course> getCourseByStudentId(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return null;
    }

    @PutMapping
    public Course updateCourse(@RequestBody Course course) {
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Long id) {
        return;
    }
}
