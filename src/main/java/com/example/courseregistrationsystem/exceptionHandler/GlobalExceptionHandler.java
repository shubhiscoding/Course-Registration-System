package com.example.courseregistrationsystem.exceptionHandler;

import com.example.courseregistrationsystem.dtos.ExceptionDto;
import com.example.courseregistrationsystem.exceptions.AdminNotFound;
import com.example.courseregistrationsystem.exceptions.*;
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
    @ExceptionHandler(AdminNotFound.class)
    public ResponseEntity<ExceptionDto> handleAdminNotFound(AdminNotFound AdminNotFound){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Admin username " + AdminNotFound.getId()+" or Password is Invalid");
        exceptionDto.setResolution("Provide valid admin username or Password");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDto> handleGeneralException(){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(" Exception is found");
//        exceptionDto.setResolution("solve exception");
//        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//        return response;
//    }
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ExceptionDto> BadRequest(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(" Bad Request Exception");
        exceptionDto.setResolution("Send all the data properly.");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
}
