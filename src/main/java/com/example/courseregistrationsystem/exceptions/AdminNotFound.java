package com.example.courseregistrationsystem.exceptions;

public class AdminNotFound extends RuntimeException {
    private Long id;
    public AdminNotFound(Long id, String message) {
        super(message);
        this.id = id;
    }
}
