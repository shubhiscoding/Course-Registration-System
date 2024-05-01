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
    public StudentResponseDto GetStudentById(@PathVariable Long id) {
        return studentService.GetStudentById(id);
    }

    @GetMapping("/course/{id}")
    public List<StudentResponseDto> getStudentsByCourseId(@PathVariable("id") Long id) {
        return studentService.getStudentsByCourseId(id);
    }

    @PutMapping
    public StudentResponseDto UpdateStudent(@RequestBody StudentRequestDto student){
        return studentService.UpdateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable Long id) {
        studentService.DeleteStudent(id);
    }

}
