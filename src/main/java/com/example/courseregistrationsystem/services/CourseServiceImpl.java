package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.exceptions.CourseNotFoundExeption;
import com.example.courseregistrationsystem.exceptions.DepartmentNotFoundException;
import com.example.courseregistrationsystem.exceptions.StudentNotFoundException;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Student;
import com.example.courseregistrationsystem.repositories.CourseRepository;
import com.example.courseregistrationsystem.repositories.DepartmentRepository;
import com.example.courseregistrationsystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;
    public CourseServiceImpl(CourseRepository courseRepository,
                             DepartmentRepository departmentRepository ,StudentRepository studentRepository){
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){

//            throw exception
            throw new CourseNotFoundExeption(id,"Invalid Course Id");
        }
        return course.get();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCourseByDepartmentId(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            //throw exception
            throw new DepartmentNotFoundException(id,"Invalid Department id");
        }
        return department.get().getCourses();
    }

    @Override
    public List<Course> getCourseByStudentId(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            //throw exception
            throw new StudentNotFoundException(id,"Invalid Student id");

        }
        return student.get().getCourses();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Optional<Course> course1 = courseRepository.findById(course.getCourseId());
        if (course1.isEmpty()){
            //throw exception
            throw new CourseNotFoundExeption(course.getCourseId(),"Invalid Course Id");
        }
        Course course2 = course1.get();
        course2.setDepartment(course.getDepartment());
        course2.setDepartment(course.getDepartment());
        course2.setName(course.getName());
        course2.setCredits(course.getCredits());

        return courseRepository.save(course2);
    }

    @Override
    public void deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            //throw exception
            throw new CourseNotFoundExeption(id,"Invalid Course Id");
        }
        courseRepository.delete(course.get());
    }
}
