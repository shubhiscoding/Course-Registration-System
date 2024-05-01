package com.example.courseregistrationsystem.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {
    @Id
    private Long studentId;
    private String name;
    private String email;
    private Date dateOfEnrollment;
    @ManyToMany
    private List<Course> courses;
}
