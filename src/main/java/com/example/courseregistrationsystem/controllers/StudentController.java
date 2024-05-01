package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.StudentRequestDto;
import com.example.courseregistrationsystem.dtos.StudentResponseDto;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Student;
import com.example.courseregistrationsystem.services.StudentService;
import com.example.courseregistrationsystem.services.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public StudentResponseDto AddStudent(@RequestBody StudentRequestDto student) {
        return studentService.AddStudent(student);
    }

    @GetMapping("/{id}")
    public Student GetStudentById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/course/{id}")
    public List<Student> getStudentsByCourseId(@PathVariable("id") Long id) {
        return null;
    }

    @PutMapping
    public Student UpdateStudent(@RequestBody Student student){
        return null;
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable Long id) {
        return;
    }

}
