package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.CourseRequestDto;
import com.example.courseregistrationsystem.exceptions.*;
import com.example.courseregistrationsystem.models.Admin;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Student;
import com.example.courseregistrationsystem.repositories.AdminRepository;
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
    private AdminRepository adminRepository;
    public CourseServiceImpl(CourseRepository courseRepository, AdminRepository adminRepository,
                             DepartmentRepository departmentRepository ,StudentRepository studentRepository){
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
        this.adminRepository = adminRepository;
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
        if (!courseRequestDto.check()){
            throw new BadRequest("Send all course details");
        }

        Course course = new Course();
        course.setName(courseRequestDto.getName());
        course.setCredits(courseRequestDto.getCredits());
        course.setDepartment(new Department());
        course.getDepartment().setDepartmentId(courseRequestDto.getDepartmentId());
        course.setDescription(courseRequestDto.getDescription());
        return course;
    }
    public boolean AdminCheck(String UserName, String password){
        Optional<Admin> admin = adminRepository.findById(UserName);
        if(admin.isEmpty()){
            throw new AdminNotFound(admin.get().getAdmin_UserName(),"Invalid User Admin");
        }
        return !password.equals(admin.get().getAdmin_Password());
    }
    @Override
    public Course addCourse(CourseRequestDto requestDto) {
        if (!requestDto.check()){
            throw new BadRequest("Send all course details");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminNotFound(requestDto.getAdminUsername(), "Invalid User Password");
        }
        return courseRepository.save(convertDto(requestDto));
    }

    @Override
    public Course updateCourse(CourseRequestDto requestDto) {
        if (!requestDto.check()){
            throw new BadRequest("Send all course details");
        }
        Optional<Course> course1 = courseRepository.findById(requestDto.getCourseId());
        if (course1.isEmpty()){
            //throw exception
            throw new CourseNotFoundExeption(requestDto.getCourseId(),"Invalid Course Id");
        }
        if(AdminCheck(requestDto.getAdminUsername(), requestDto.getPassword())){
            throw new AdminNotFound(requestDto.getAdminUsername(), "Invalid User Password");
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
