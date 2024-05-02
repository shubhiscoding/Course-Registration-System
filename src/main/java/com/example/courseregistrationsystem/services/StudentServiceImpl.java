package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.CourseResponseDto;
import com.example.courseregistrationsystem.dtos.StudentRequestDto;
import com.example.courseregistrationsystem.dtos.StudentResponseDto;
import com.example.courseregistrationsystem.exceptions.CourseNotFoundExeption;
import com.example.courseregistrationsystem.exceptions.StudentNotFoundException;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Student;
import com.example.courseregistrationsystem.repositories.CourseRepository;
import com.example.courseregistrationsystem.repositories.StudentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Getter
@Setter
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    public StudentServiceImpl(StudentRepository studentRepositor, CourseRepository courseRepository){
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepositor;
    }
    @Override
    public StudentResponseDto AddStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setStudentId(studentRequestDto.getStudentId());
        Student student1 = studentRepository.save(student);

        System.out.println("AddStudent is called");
        return new StudentResponseDto(student1);
    }

    @Override
    public StudentResponseDto GetStudentById(Long id) {
        Optional<Student> student1 = studentRepository.findById(id);
        if(student1.isEmpty()){
            throw new StudentNotFoundException(id,"Invalid student id");
        }

        System.out.println("GetStudentById is called");
        return new StudentResponseDto(student1.get());
    }

    @Override
    public StudentResponseDto enrollstudent(StudentRequestDto student) {
        Optional<Course> course = courseRepository.findById(student.getCourseId());
        if(course.isEmpty()){
            throw new CourseNotFoundExeption(student.getStudentId(), "Course not found");
        }
        Optional<Student> std = studentRepository.findById(student.getStudentId());
        if(std.isEmpty()){
            throw new StudentNotFoundException(student.getStudentId(), "Student Not Found");
        }
        Student student1 = std.get();
        if(!student1.getCourses().isEmpty()){
            student1.getCourses().add(course.get());
        }else{
            List<Course> list = new ArrayList<>();
            list.add(course.get());
            student1.setCourses(list);
        }
        studentRepository.save(student1);
        if(!course.get().getStudents().isEmpty()) {
            course.get().getStudents().add(student1);
        }else{
            List<Student> list2 = new ArrayList<>();
            list2.add(student1);
            course.get().setStudents(list2);
        }
        courseRepository.save(course.get());
        System.out.println("enrollstudent is called");
        return new StudentResponseDto(student1);
    }

    @Override
    public List<StudentResponseDto> getStudentsByCourseId(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
        if(course.isEmpty()){
            //throw exception
            throw new StudentNotFoundException(id,"Invalid Student id");

        }
        for(Student student : course.get().getStudents()){
            studentResponseDtoList.add(new StudentResponseDto(student));
        }

        System.out.println("getStudentsByCourseId is called");
        return studentResponseDtoList;
    }

    @Override
    public StudentResponseDto UpdateStudent(StudentRequestDto studentRequestDto) {
        Optional<Student> student = studentRepository.findById(studentRequestDto.getStudentId());
        if(student.isEmpty()){
            throw new StudentNotFoundException(studentRequestDto.getStudentId(),"Invalid Student id");
        }
        Student student1 = student.get();
        student1.setEmail(studentRequestDto.getEmail());
        student1.setName(studentRequestDto.getName());
        studentRepository.save(student1);

        System.out.println("UpdateStudent is called");
        return new StudentResponseDto(student1);
    }

    @Override
    public void DeleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException(id,"Invalid Student id");
        }
        studentRepository.delete(student.get());
        System.out.println("DeleteStudent is called");
    }
}