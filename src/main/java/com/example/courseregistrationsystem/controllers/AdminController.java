package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.AdminResponseDto;
import com.example.courseregistrationsystem.models.Admin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/")
    public AdminResponseDto createAdmin(@RequestBody Admin admin) {
        return null;
    }

    @PatchMapping("/")
    public AdminResponseDto updateAdmin(@RequestBody Admin admin) {
        return null;
    }

    @DeleteMapping("/")
    public void deleteAdmin(@RequestBody Admin admin) {
        return;
    }

    @GetMapping("/{id}")
    public AdminResponseDto getAdmin(@PathVariable int id) {
        return null;
    }
}
