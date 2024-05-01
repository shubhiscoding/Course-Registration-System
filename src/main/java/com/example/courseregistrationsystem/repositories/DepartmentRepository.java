package com.example.courseregistrationsystem.repositories;

import com.example.courseregistrationsystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    Department save(Department department);

    @Override
    Optional<Department> findById(Long Id);

    @Override
    List<Department> findAll();

    @Override
    void delete(Department department);
    
}
