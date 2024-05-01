package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentRequestDto {
    private Long departmentId;
    private String name;
    private String adminUsername;
    private String password;

    public boolean check(){
        return this.departmentId != null && this.departmentId > 0 &&
                this.name != null && !this.name.isEmpty() &&
                this.adminUsername != null && this.password != null;
    }
}
