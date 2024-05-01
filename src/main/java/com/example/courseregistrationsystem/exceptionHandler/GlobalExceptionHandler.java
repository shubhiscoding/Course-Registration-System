package com.example.courseregistrationsystem.exceptionHandler;

import com.example.courseregistrationsystem.dtos.ExceptionDto;
import com.example.courseregistrationsystem.exceptions.CourseNotFoundExeption;
import com.example.courseregistrationsystem.exceptions.DepartmentNotFoundException;
import com.example.courseregistrationsystem.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CourseNotFoundExeption.class)
public ResponseEntity<ExceptionDto> handleCourseNotFoundException(CourseNotFoundExeption courseNotFoundExeption){
    ExceptionDto exceptionDto = new ExceptionDto();
    exceptionDto.setMessage("Course Id" + courseNotFoundExeption.getId()+"is Invalid");
    exceptionDto.setResolution("Provide valid Course id");
ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
return responseEntity;
}
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleDepartmentNotFoundException(DepartmentNotFoundException departmentNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Department Id" + departmentNotFoundException.getId()+"is Invalid");
        exceptionDto.setResolution("Provide valid Course ic");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Student Id" + studentNotFoundException.getId()+"is Invalid");
        exceptionDto.setResolution("Provide valid Course ic");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(" Exception is found");
        exceptionDto.setResolution("solve exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
}
