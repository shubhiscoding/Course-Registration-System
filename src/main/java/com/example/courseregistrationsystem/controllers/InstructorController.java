package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.models.Instructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return null;
    }

    @GetMapping("/courses/{id}")
    public Instructor getInstructorByCourseId(@PathVariable Long id) {
        return null;
    }
    @GetMapping("/department/{id}")
    public Instructor getInstructorByDepartmentId(@PathVariable Long id) {
        return null;
    }
    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return null;
    }

    @PutMapping
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        return;
    }
}
