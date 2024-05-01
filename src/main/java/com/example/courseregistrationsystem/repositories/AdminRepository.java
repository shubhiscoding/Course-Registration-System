package com.example.courseregistrationsystem.repositories;

import com.example.courseregistrationsystem.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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
