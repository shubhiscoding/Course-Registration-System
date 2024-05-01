package com.example.courseregistrationsystem.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String message) {
        super(message);
    }
}
