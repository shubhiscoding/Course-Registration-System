package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.CourseRequestDto;
import com.example.courseregistrationsystem.models.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CourseService {
    Course getCourseById(@PathVariable("id") Long id);
    List<Course> getAllCourses();
    List<Course> getCourseByDepartmentId(@PathVariable Long id);
    List<Course> getCourseByStudentId(@PathVariable Long id);
    Course addCourse(@RequestBody CourseRequestDto requestDto);
    Course updateCourse(@RequestBody CourseRequestDto requestDto);
    void deleteCourse(@PathVariable("id") Long id);
}
