package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.AdminRequestDto;
import com.example.courseregistrationsystem.dtos.AdminResponseDto;
import com.example.courseregistrationsystem.exceptions.AdminNotFound;
import com.example.courseregistrationsystem.exceptions.BadRequest;
import com.example.courseregistrationsystem.models.Admin;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.repositories.AdminRepository;
import org.apache.coyote.BadRequestException;

import java.util.Optional;

public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    public AdminResponseDto createAdmin(AdminRequestDto admin) {
        if(!admin.check()){
           throw new BadRequest("Send all the admin details");
        }
        Admin adminEntity = new Admin();
        adminEntity.setAdmin_Email(admin.getAdmin_Email());
        adminEntity.setAdmin_UserName(admin.getAdmin_UserName());
        adminEntity.setAdmin_Password(admin.getAdmin_Password());
        adminEntity.setAdmin_FirstName(admin.getAdmin_FirstName());
        adminEntity.setAdmin_LastName(admin.getAdmin_LastName());
        return new AdminResponseDto(adminEntity);
    }

    @Override
    public AdminResponseDto updateAdmin(AdminRequestDto admin) {
        if(!admin.check()){
            throw new BadRequest("Send all the admin details");
        }
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdminId());
        if(admin1.isEmpty()){
            throw new AdminNotFound(admin.getAdminId(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        admin2.setAdmin_Email(admin.getAdmin_Email());
        admin2.setAdmin_UserName(admin.getAdmin_UserName());
        admin2.setAdmin_FirstName(admin.getAdmin_FirstName());
        admin2.setAdmin_LastName(admin.getAdmin_LastName());
        return new AdminResponseDto(admin2);
    }

    @Override
    public void deleteAdmin(AdminRequestDto admin) {
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdminId());
        if(admin1.isEmpty()){
            throw new AdminNotFound(admin.getAdminId(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        if(admin2.getAdmin_UserName().equals(admin.getAdmin_UserName()) && admin2.getAdmin_Password().equals(admin.getAdmin_Password())){
            adminRepository.deleteById(admin.getAdminId());
        }else{
            throw new AdminNotFound(admin.getAdminId(), "Wrong Admin Username or Password");
        }
        adminRepository.deleteById(admin.getAdminId());
    }

    @Override
    public AdminResponseDto getAdmin(Long id) {
        Optional<Admin> admin1 = adminRepository.findById(id);
        if(admin1.isEmpty()){
            throw new AdminNotFound(id, "Admin not found");
        }
        return new AdminResponseDto(admin1.get());
    }
}
