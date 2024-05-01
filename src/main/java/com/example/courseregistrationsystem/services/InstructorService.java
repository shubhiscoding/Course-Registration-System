package com.example.courseregistrationsystem.services;

<<<<<<< HEAD
public interface InstructorService {
=======
import com.example.courseregistrationsystem.dtos.InstructorRequestDto;
import com.example.courseregistrationsystem.dtos.InstructorResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InstructorService {
    public InstructorResponseDto getInstructorById(@PathVariable Long id);

    public List<InstructorResponseDto> getAllInstructors();

    public InstructorResponseDto getInstructorByCourseId(@PathVariable Long id);

    public List<InstructorResponseDto> getInstructorByDepartmentId(@PathVariable Long id);

    public InstructorResponseDto createInstructor(@RequestBody InstructorRequestDto instructor);

    public InstructorResponseDto updateInstructor(@RequestBody InstructorRequestDto instructor);

    public void deleteInstructor(@RequestBody InstructorRequestDto instructor);
>>>>>>> 6d1d63bcbfe3efcbb6d09c06da87b618d9a7f890
}
