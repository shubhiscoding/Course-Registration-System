package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CourseRequestDto {
    private Long courseId;
    private String name;
    private String description;
    private int credits;
    private Long departmentId;
    private String adminUsername;
    private String password;

    public boolean check(){
        return this.name != null && !this.name.isEmpty() &&
                this.adminUsername != null && !this.adminUsername.isEmpty() &&
                this.description != null && !this.description.isEmpty() &&
                this.password != null && this.departmentId != null && this.credits > 0 &&
                this.departmentId > 0 && !this.password.isEmpty();
    }
}
