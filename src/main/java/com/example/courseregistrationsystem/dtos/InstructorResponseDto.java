package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Instructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class InstructorResponseDto {
    private Long instructorId;
    private String name;
    private String title;
    private Department department;
    private List<String> courses;

    public InstructorResponseDto(Instructor instructor) {
        this.instructorId = instructor.getInstructorId();
        this.name = instructor.getName();
        this.title = instructor.getTitle();
        this.department = instructor.getDepartment();
        List<Course> courses = instructor.getCourses();
        if(courses!=null && courses.size()>0) {
            this.courses = new ArrayList<>();
            for (Course course : courses) {
                this.courses.add(course.getName());
            }
        }else{
            this.courses = new ArrayList<>();
        }
    }
}
