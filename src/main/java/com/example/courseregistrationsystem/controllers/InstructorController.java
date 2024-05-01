package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.InstructorRequestDto;
import com.example.courseregistrationsystem.dtos.InstructorResponseDto;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.services.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private InstructorService instructorService;
    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }
    @GetMapping("/{id}")
    public InstructorResponseDto getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @GetMapping
    public List<InstructorResponseDto> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/courses/{id}")
    public InstructorResponseDto getInstructorByCourseId(@PathVariable Long id) {
        return instructorService.getInstructorByCourseId(id);
    }
    @GetMapping("/department/{id}")
    public List<InstructorResponseDto> getInstructorByDepartmentId(@PathVariable Long id) {
        return instructorService.getInstructorByDepartmentId(id);
    }

    @PostMapping
    public InstructorResponseDto createInstructor(@RequestBody InstructorRequestDto instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping
    public InstructorResponseDto updateInstructor(@RequestBody InstructorRequestDto instructor) {
        return instructorService.updateInstructor(instructor);
    }

    @DeleteMapping("")
    public void deleteInstructor(@RequestBody InstructorRequestDto instructor) {
        return;
    }
}
