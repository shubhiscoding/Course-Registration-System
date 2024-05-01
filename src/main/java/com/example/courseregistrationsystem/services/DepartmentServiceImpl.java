package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.DepartmentRequestDto;
import com.example.courseregistrationsystem.dtos.DepartmentResponseDto;
import com.example.courseregistrationsystem.exceptions.DepartmentNotFoundException;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository departmentRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department convertDto(DepartmentRequestDto requestDto){
        Department department = new Department();
//        department.setDepartmentId(requestDto.getDepartmentId());
        department.setName(department.getName());
        Optional<Department> department1 = departmentRepository.findById(requestDto.getDepartmentId());
        if(department1.isPresent()){
            department.setDepartmentId(department1.get().getDepartmentId());
            department.setCourses(department1.get().getCourses());
        }
        return department;
    }

    @Override
    public Department getDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            //throw exception
            throw new DepartmentNotFoundException(id,"Invalid Department id");

        }
        return department.get();
    }


    @Override
    public Department addDepartment(DepartmentRequestDto requestDto) {
        Department department = new Department();
        department.setName(requestDto.getName());
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(DepartmentRequestDto requestDto) {
        Optional<Department> department1 = departmentRepository.findById(requestDto.getDepartmentId());
        if(department1.isEmpty()){
            //throw exception
            throw new DepartmentNotFoundException(requestDto.getDepartmentId(),"Invalid Department id");
        }
        department1.get().setName(requestDto.getName());
        return department1.get();
    }

    @Override
    public String deleteDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            throw new DepartmentNotFoundException(id,"Department does not exist");
        }
        departmentRepository.delete(department.get());
        return "Deleted the department";
    }
}
