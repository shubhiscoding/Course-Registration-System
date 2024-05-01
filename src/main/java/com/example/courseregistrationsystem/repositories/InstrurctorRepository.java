package com.example.courseregistrationsystem.repositories;

import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstrurctorRepository extends JpaRepository<Instructor, Long> {
    @Override
    Instructor save(Instructor instructor);

    @Override
    Optional<Instructor> findById(Long Id);

    @Override
    List<Instructor> findAll();

    @Override
    void delete(Instructor instructor);
}
