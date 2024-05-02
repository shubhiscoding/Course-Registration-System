package com.example.courseregistrationsystem.controllers;

import com.example.courseregistrationsystem.dtos.DepartmentRequestDto;
import com.example.courseregistrationsystem.dtos.DepartmentResponseDto;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){

        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public DepartmentResponseDto getDepartment(@PathVariable Long id) {
        Department department = departmentService.getDepartment(id);
        return new DepartmentResponseDto(department);

    }

    @PostMapping("/")
    public DepartmentResponseDto addDepartment(@RequestBody DepartmentRequestDto requestDto) {
        Department department = departmentService.addDepartment(requestDto);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setDepartmentId(department.getDepartmentId());
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setCourses(new ArrayList<>());
        if(department.getCourses() != null){
            for(Course course : department.getCourses()){
                departmentResponseDto.getCourses().add(course.getName());
            }
        }
        return departmentResponseDto;
    }

    @PutMapping("/")
    public DepartmentResponseDto updateDepartment(@RequestBody DepartmentRequestDto requestDto) {

        return new DepartmentResponseDto(departmentService.updateDepartment(requestDto));
    }

    @DeleteMapping("/")
    public String deleteDepartment(@RequestBody DepartmentRequestDto departmentRequestDto) {
        return departmentService.deleteDepartment(departmentRequestDto.getDepartmentId());
}

}