package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.repositories.DepartmentRepository;

import java.util.ArrayList;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository departmentRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department getDepartment(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            //throw exception
        }
        return department.get();
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        Optional<Department> department1 = departmentRepository.findById(department.getDepartmentId());
        department1.get().setName(department.getName());
        department1.get().setCourses(new ArrayList<>());
//        if(department.getCourses() != null){
//            for(Course course : department.getCourses()){
//                Course course1 = new Course();
//                course1.
//            }
//        }
        return department1.get();
    }

    @Override
    public String deleteDepartment(Department department) {
        departmentRepository.delete(department);
        return "Deleted the department";
    }
}
