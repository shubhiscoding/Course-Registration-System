package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.AdminRequestDto;
import com.example.courseregistrationsystem.dtos.AdminResponseDto;
import com.example.courseregistrationsystem.models.Admin;
import org.springframework.web.bind.annotation.*;

public interface AdminService {
    public AdminResponseDto createAdmin(@RequestBody AdminRequestDto admin);

    public AdminResponseDto updateAdmin(@RequestBody AdminRequestDto admin);

    public void deleteAdmin(@RequestBody AdminRequestDto admin);

    public AdminResponseDto getAdmin(@PathVariable String username);
}
