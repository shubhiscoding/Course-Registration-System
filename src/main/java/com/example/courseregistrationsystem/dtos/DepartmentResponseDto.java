package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class DepartmentResponseDto {


    private Long departmentId;
    private String name;
    private List<String> courses;
    public DepartmentResponseDto(Department department) {
        this.departmentId = departmentId;
        this.name = name;
        this.courses = new ArrayList<>();
        if(department.getCourses()!=null){
            for(Course course : department.getCourses()){
                this.courses.add(course.getName());
            }
        }
    }
}
