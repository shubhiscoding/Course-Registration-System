package com.example.courseregistrationsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    private int adminId;
    private String admin_UserName;
    private String admin_Password;
    private String admin_Email;
    private String admin_FirstName;
    private String admin_LastName;
}
