package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class StudentResponseDto {
    private Long studentId;
    private String name;
    private String email;
//    private Date dateOfEnrollment;
    private List<String> courses;

    public StudentResponseDto(Student student) {

        if(student.getStudentId()!=null && student.getStudentId() > 0) {
            this.studentId = student.getStudentId();
        }
        if(student.getName()!=null) {
            this.name = student.getName();
        }
        if(student.getEmail()!=null) {
            this.email = student.getEmail();
        }
//        this.dateOfEnrollment = student.getDateOfEnrollment();
        this.courses = new ArrayList<>();
        List<Course> temp = student.getCourses();
        if(temp!=null && !temp.isEmpty() && temp.size()>0) {
            for (int i = 0; i < temp.size(); i++) {
                courses.add(temp.get(i).getName());
            }
        }
    }
}
