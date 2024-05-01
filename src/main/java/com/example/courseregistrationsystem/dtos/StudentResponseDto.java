package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class StudentResponseDto {
    private Long studentId;
    private String name;
    private String email;
    private Date dateOfEnrollment;
    private List<String> courses;

    public StudentResponseDto(Student student) {
        this.studentId = student.getStudentId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.dateOfEnrollment = student.getDateOfEnrollment();
        this.courses = new ArrayList<>();
        List<Course> temp = student.getCourses();
        for(int i=0;i<temp.size();i++){
            courses.add(temp.get(i).getName());
        }
    }
}
