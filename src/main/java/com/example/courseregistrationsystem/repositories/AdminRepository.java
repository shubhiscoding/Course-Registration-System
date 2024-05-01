package com.example.courseregistrationsystem.repositories;

import com.example.courseregistrationsystem.models.Admin;
import com.example.courseregistrationsystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Override
    Admin save(Admin admin);

    @Override
    Optional<Admin> findById(Long Id);

    @Override
    List<Admin> findAll();

    @Override
    void delete(Admin admin);
}
