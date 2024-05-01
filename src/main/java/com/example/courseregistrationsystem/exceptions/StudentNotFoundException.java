package com.example.courseregistrationsystem.exceptions;

import lombok.Getter;

@Getter
public class StudentNotFoundException extends RuntimeException{
    private Long id;
    public StudentNotFoundException(Long id , String message){
        super(message);
        this.id = id;
    }
}
