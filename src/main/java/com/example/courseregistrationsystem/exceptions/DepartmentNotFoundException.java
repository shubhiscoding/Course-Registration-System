package com.example.courseregistrationsystem.exceptions;

import lombok.Getter;

@Getter
public class DepartmentNotFoundException extends RuntimeException{
    public Long id;
    public DepartmentNotFoundException(Long id,String message){
        super(message);
        this.id= id;
    }
}
