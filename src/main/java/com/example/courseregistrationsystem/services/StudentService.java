package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.StudentRequestDto;
import com.example.courseregistrationsystem.dtos.StudentResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentService {
    StudentResponseDto AddStudent(@RequestBody StudentRequestDto studentRequestDto);
    StudentResponseDto GetStudentById(@PathVariable Long id);
    StudentResponseDto enrollstudent(@RequestBody StudentRequestDto student);
    List<StudentResponseDto> getStudentsByCourseId(@PathVariable("id") Long id);
    StudentResponseDto UpdateStudent(@RequestBody StudentRequestDto studentRequestDto);
    void DeleteStudent(@PathVariable Long id);
}