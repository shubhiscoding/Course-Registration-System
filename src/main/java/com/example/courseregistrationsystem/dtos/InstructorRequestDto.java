package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InstructorRequestDto {
    private Long instructorId;
    private String name;
    private String title;
    private Long  departmentId;
    private String adminUsername;
    private String password;

    public boolean check(){
        if(this.name.isEmpty() || this.name.length() ==0 || this.title.isEmpty() || this.title.length() ==0 || this.departmentId == null || this.departmentId < 0
                || this.adminUsername==null || this.adminUsername.length()==0 || this.password==null || this.password.isEmpty() || this.password.length() ==0){
            return false;
        }
        return true;
    }
}
