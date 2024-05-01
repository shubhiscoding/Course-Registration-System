package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.AdminRequestDto;
import com.example.courseregistrationsystem.dtos.AdminResponseDto;
import com.example.courseregistrationsystem.models.Admin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/")
    public AdminResponseDto createAdmin(@RequestBody AdminRequestDto admin) {
        return null;
    }

    @PatchMapping("/")
    public AdminResponseDto updateAdmin(@RequestBody AdminRequestDto admin) {
        return null;
    }

    @DeleteMapping("/")
    public void deleteAdmin(@RequestBody AdminRequestDto admin) {
        return;
    }

    @GetMapping("/{id}")
    public AdminResponseDto getAdmin(@PathVariable Long id) {
        return null;
    }
}
