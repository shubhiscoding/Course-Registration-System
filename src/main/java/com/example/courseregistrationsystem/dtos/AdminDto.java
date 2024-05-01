package com.example.courseregistrationsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private int adminId;
    private String admin_UserName;
    private String admin_Email;
    private String admin_FirstName;
    private String admin_LastName;
}
