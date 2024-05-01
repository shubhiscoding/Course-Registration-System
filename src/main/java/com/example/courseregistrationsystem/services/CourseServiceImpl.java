package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.CourseRequestDto;
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

    public Course convertDto(CourseRequestDto courseRequestDto){
        Course course = new Course();
        course.setName(courseRequestDto.getName());
        course.setCredits(courseRequestDto.getCredits());
        course.setDepartment(new Department());
        course.getDepartment().setDepartmentId(courseRequestDto.getDepartmentId());
        course.setDescription(courseRequestDto.getDescription());
        return course;
    }

    @Override
    public Course addCourse(CourseRequestDto requestDto) {
        return courseRepository.save(convertDto(requestDto));
    }

    @Override
    public Course updateCourse(CourseRequestDto requestDto) {
        Optional<Course> course1 = courseRepository.findById(requestDto.getCourseId());
        if (course1.isEmpty()){
            //throw exception
            throw new CourseNotFoundExeption(requestDto.getCourseId(),"Invalid Course Id");
        }
        Course course2 = convertDto(requestDto);
        course2.setCourseId(requestDto.getCourseId());

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
