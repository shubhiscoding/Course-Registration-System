package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.DepartmentRequestDto;
import com.example.courseregistrationsystem.dtos.DepartmentResponseDto;
import com.example.courseregistrationsystem.exceptions.AdminNotFound;
import com.example.courseregistrationsystem.exceptions.BadRequest;
import com.example.courseregistrationsystem.exceptions.DepartmentNotFoundException;
import com.example.courseregistrationsystem.models.Admin;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.repositories.AdminRepository;
import com.example.courseregistrationsystem.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    private AdminRepository adminRepository;
    private DepartmentRepository departmentRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,AdminRepository adminRepository){
        this.departmentRepository = departmentRepository;
        this.adminRepository = adminRepository;
    }

    public Department convertDto(DepartmentRequestDto requestDto){
        if(!requestDto.check()){
            throw new BadRequest("Send All Department Details");
        }
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

        System.out.println("getDepartment is called");
        return department.get();
    }

    public boolean AdminCheck(String UserName, String password){
        Optional<Admin> admin = adminRepository.findById(UserName);
        if(admin.isEmpty()){
            throw new AdminNotFound(admin.get().getAdmin_UserName(),"Invalid User Admin");
        }

        System.out.println("AdminCheck is called");
        return !password.equals(admin.get().getAdmin_Password());
    }

    @Override
    public Department addDepartment(DepartmentRequestDto requestDto) {
        if(!requestDto.check()){
            throw new BadRequest("Send All Department Details");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminNotFound(requestDto.getAdminUsername(), "Invalid User Password");
        }
        Department department = new Department();
        department.setName(requestDto.getName());

        System.out.println("addDepartment is called");
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(DepartmentRequestDto requestDto) {
        if(!requestDto.check()){
            throw new BadRequest("Send All Department Details");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminNotFound(requestDto.getAdminUsername(), "Invalid User Password");
        }
        Optional<Department> department1 = departmentRepository.findById(requestDto.getDepartmentId());
        if(department1.isEmpty()){
            //throw exception
            throw new DepartmentNotFoundException(requestDto.getDepartmentId(),"Invalid Department id");
        }
        department1.get().setName(requestDto.getName());

        System.out.println("updateDepartment is called");
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
