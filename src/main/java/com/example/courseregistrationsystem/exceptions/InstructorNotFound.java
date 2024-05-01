package com.example.courseregistrationsystem.exceptions;

import lombok.Getter;

@Getter
public class InstructorNotFound extends RuntimeException{
    private Long id;
    public InstructorNotFound(Long id, String str){
        super(str);
        this.id = id;
    }
}
