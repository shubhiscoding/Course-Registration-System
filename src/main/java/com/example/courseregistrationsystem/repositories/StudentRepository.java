package com.example.courseregistrationsystem.repositories;
import com.example.courseregistrationsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    Student save(Student student);

    @Override
    Optional<Student> findById(Long Id);

    @Override
    List<Student> findAll();

    @Override
    void delete(Student student);
}
