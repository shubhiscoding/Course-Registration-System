package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.models.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CourseService {
    Course getCourseById(@PathVariable("id") Long id);
    List<Course> getAllCourses();
    List<Course> getCourseByDepartmentId(@PathVariable Long id);
    List<Course> getCourseByStudentId(@PathVariable Long id);
    Course addCourse(@RequestBody Course course);
    Course updateCourse(@RequestBody Course course);
    void deleteCourse(@PathVariable("id") Long id);
}
