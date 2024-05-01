package com.example.courseregistrationsystem.dtos;

import com.example.courseregistrationsystem.models.Admin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminResponseDto {
    private String admin_UserName;
    private String admin_Email;
    private String admin_FirstName;
    private String admin_LastName;

    public AdminResponseDto(Admin admin) {
        this.admin_Email = admin.getAdmin_Email();
        this.admin_FirstName = admin.getAdmin_FirstName();
        this.admin_LastName = admin.getAdmin_LastName();
        this.admin_UserName = admin.getAdmin_UserName();
    }
}

