package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.AdminRequestDto;
import com.example.courseregistrationsystem.dtos.AdminResponseDto;
import com.example.courseregistrationsystem.exceptions.AdminNotFound;
import com.example.courseregistrationsystem.exceptions.BadRequest;
import com.example.courseregistrationsystem.models.Admin;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.repositories.AdminRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
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
        Admin admin1 = adminRepository.save(adminEntity);

        System.out.println("createAdmin is called");
        return new AdminResponseDto(admin1);
    }

    @Override
    public AdminResponseDto updateAdmin(AdminRequestDto admin) {
        System.out.println("updateAdmin is called");
        if(!admin.check()){
            throw new BadRequest("Send all the admin details");
        }
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdmin_UserName());
        if(admin1.isEmpty()){
            throw new AdminNotFound(admin.getAdmin_UserName(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        if(admin2.getAdmin_Password().equals(admin.getAdmin_Password())) {
            admin2.setAdmin_Email(admin.getAdmin_Email());
            admin2.setAdmin_UserName(admin.getAdmin_UserName());
            admin2.setAdmin_FirstName(admin.getAdmin_FirstName());
            admin2.setAdmin_LastName(admin.getAdmin_LastName());
            return new AdminResponseDto(admin2);
        }else{
            throw new AdminNotFound(admin.getAdmin_UserName(), "Wrong Admin Password");
        }
    }

    @Override
    public void deleteAdmin(AdminRequestDto admin) {
        Optional<Admin> admin1 = adminRepository.findById(admin.getAdmin_UserName());
        if(admin1.isEmpty()){
            throw new AdminNotFound(admin.getAdmin_UserName(), "Admin not found");
        }
        Admin admin2 = admin1.get();
        if(admin2.getAdmin_UserName().equals(admin.getAdmin_UserName()) && admin2.getAdmin_Password().equals(admin.getAdmin_Password())){
            adminRepository.deleteById(admin.getAdmin_UserName());
        }else{
            throw new AdminNotFound(admin.getAdmin_UserName(), "Wrong Admin Username or Password");
        }
        System.out.println("deleteAdmin is called");
        adminRepository.deleteById(admin.getAdmin_UserName());
    }

    @Override
    public AdminResponseDto getAdmin(String username) {
        Optional<Admin> admin1 = adminRepository.findById(username);
        if(admin1.isEmpty()){
            throw new AdminNotFound(username, "Admin not found");
        }
        System.out.println("getAdmin is called");
        return new AdminResponseDto(admin1.get());
    }
}
