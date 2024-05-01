package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @PostMapping
    public Student AddStudent(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return null;
    }

    @GetMapping("/{id}")
    public Student GetStudentById(@PathVariable int id) {
        return null;
    }

    @GetMapping("/course/{id}")
    public List<Student> getStudentsByCourseId(@PathVariable("id") int id) {
        return null;
    }

    @PutMapping
    public Student UpdateStudent(@RequestBody Student student){
        return null;
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable int id) {
        return;
    }

}
