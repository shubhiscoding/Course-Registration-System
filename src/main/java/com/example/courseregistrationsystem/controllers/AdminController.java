package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.AdminRequestDto;
import com.example.courseregistrationsystem.dtos.AdminResponseDto;
import com.example.courseregistrationsystem.models.Admin;
import com.example.courseregistrationsystem.services.AdminServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminServiceImpl adminService;
    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/")
    public AdminResponseDto createAdmin(@RequestBody AdminRequestDto admin) {
        return adminService.createAdmin(admin);
    }

    @PatchMapping("/")
    public AdminResponseDto updateAdmin(@RequestBody AdminRequestDto admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/")
    public void deleteAdmin(@RequestBody AdminRequestDto admin) {
        adminService.deleteAdmin(admin);
    }

    @GetMapping("/{username}")
    public AdminResponseDto getAdmin(@PathVariable("username") String username) {
        return adminService.getAdmin(username);
    }
}
