package com.example.courseregistrationsystem.exceptions;

import lombok.Getter;

@Getter
public class AdminNotFound extends RuntimeException {
    private String id;
    public AdminNotFound(String id, String message) {
        super(message);
        this.id = id;
    }
}
