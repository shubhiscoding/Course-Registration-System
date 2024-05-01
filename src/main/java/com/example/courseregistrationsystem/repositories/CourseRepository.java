package com.example.courseregistrationsystem.repositories;

import com.example.courseregistrationsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    Course save(Course course);

    @Override
    Optional<Course> findById(Long Id);

    @Override
    List<Course> findAll();

    @Override
    void delete(Course course);
}
