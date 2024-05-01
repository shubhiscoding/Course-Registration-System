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


    @GetMapping("/{id}")
    public CourseResponseDto getCourseById(@PathVariable("id") Long id) {
        Course course = courseService.getCourseById(id);
        return new CourseResponseDto(course);
    }

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
        List<CourseResponseDto> courseResponseDtos = new ArrayList<>();
        List<Course> courses = courseService.getAllCourses();
        for(Course course : courses){
            courseResponseDtos.add(new CourseResponseDto(course));
        }
        return courseResponseDtos;
    }

    @GetMapping("/department/{id}")
    public List<CourseResponseDto> getCourseByDepartmentId(@PathVariable Long id) {
        List<CourseResponseDto> courseResponseDtos = new ArrayList<>();
        List<Course> courses = courseService.getCourseByDepartmentId(id);
        for(Course course : courses){
            courseResponseDtos.add(new CourseResponseDto(course));
        }
        return courseResponseDtos;
    }

    @GetMapping("/student/{id}")
    public List<CourseResponseDto> getCourseByStudentId(@PathVariable Long id) {
        List<CourseResponseDto> courseResponseDtos = new ArrayList<>();
        List<Course> courses = courseService.getCourseByStudentId(id);
        for(Course course : courses){
            courseResponseDtos.add(new CourseResponseDto(course));
        }
        return courseResponseDtos;
    }

    @PostMapping
    public CourseResponseDto addCourse(@RequestBody CourseRequestDto requestDto) {
        return new CourseResponseDto(courseService.addCourse(requestDto));
    }

    @PutMapping
    public CourseResponseDto updateCourse(@RequestBody CourseRequestDto requestDto) {
        return new CourseResponseDto(courseService.updateCourse(requestDto));
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
    }
}
