package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.AdminDto;
import com.example.courseregistrationsystem.models.Admin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/")
    public AdminDto createAdmin(@RequestBody Admin admin) {
        return null;
    }

    @PatchMapping("/")
    public AdminDto updateAdmin(@RequestBody Admin admin) {
        return null;
    }

    @DeleteMapping("/")
    public void deleteAdmin(@RequestBody Admin admin) {
        return;
    }

    @GetMapping("/{id}")
    public AdminDto getAdmin(@PathVariable int id) {
        return null;
    }
}
