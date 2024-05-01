package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.CourseRequestDto;
import com.example.courseregistrationsystem.dtos.CourseResponseDto;
import com.example.courseregistrationsystem.exceptions.CourseNotFoundExeption;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.models.Student;
import com.example.courseregistrationsystem.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/courses/")
public class CourseController {

    private CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

//    public CourseResponseDto ConvertToDTO(Course course){
//        CourseResponseDto courseResponseDto = new CourseResponseDto();
//    }
//
    @GetMapping("/{id}")
    public CourseResponseDto getCourseById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
        return null;
    }

    @GetMapping("/department/{id}")
    public List<CourseResponseDto> getCourseByDepartmentId(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/student/{id}")
    public List<CourseResponseDto> getCourseByStudentId(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public CourseResponseDto addCourse(@RequestBody CourseRequestDto requestDto) {
        return null;
    }

    @PutMapping
    public CourseResponseDto updateCourse(@RequestBody CourseRequestDto requestDto) {
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Long id) {
        return;
    }
}
