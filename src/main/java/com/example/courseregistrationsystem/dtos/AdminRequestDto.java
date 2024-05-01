package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequestDto {
    private Long adminId;
    private String admin_UserName;
    private String admin_Email;
    private String admin_FirstName;
    private String admin_LastName;
    private String admin_Password;


    public boolean check(){
        if(this.admin_Email == null || this.admin_Email.isEmpty()){
            return false;
        }
        if(this.admin_FirstName == null || this.admin_FirstName.isEmpty()){
            return false;
        }
        if(this.admin_LastName == null || this.admin_LastName.isEmpty()){
            return false;
        }
        if(this.admin_Password == null || this.admin_Password.isEmpty()){
            return false;
        }
        if(this.admin_UserName == null || this.admin_UserName.isEmpty()){
            return false;
        }
        return true;
    }
}
