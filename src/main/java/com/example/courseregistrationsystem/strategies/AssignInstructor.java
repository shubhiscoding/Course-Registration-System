package com.example.courseregistrationsystem.strategies;

import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.repositories.InstructorRepository;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class AssignInstructor {
    private InstructorRepository instructorRepository;
    public AssignInstructor(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;
    }
    public void Instructor(Course course){
        List<Instructor> instructors = instructorRepository.findAll();
        for(Instructor instructor : instructors){
            Long departmentId_Course = course.getDepartment().getDepartmentId();
            Long departmentId_Instructor = course.getDepartment().getDepartmentId();
            if(departmentId_Instructor == departmentId_Course){
                course.setInstructor(instructor);
                break;
            }
        }
    }
}
