package com.example.courseregistrationsystem.exceptions;

import lombok.Getter;

@Getter

public class CourseNotFoundExeption extends RuntimeException {
    private Long id;
    public CourseNotFoundExeption(Long id, String message){
        super(message);
        this.id = id;
    }

}
