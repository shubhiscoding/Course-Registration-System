package com.example.courseregistrationsystem.services;

import com.example.courseregistrationsystem.dtos.CourseResponseDto;
import com.example.courseregistrationsystem.dtos.StudentRequestDto;
import com.example.courseregistrationsystem.dtos.StudentResponseDto;
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
        return new StudentResponseDto(student);
    }

    @Override
    public StudentResponseDto GetStudentById(Long id) {
        Optional<Student> student1 = studentRepository.findById(id);
        if(student1.isEmpty()){
            throw new StudentNotFoundException(id,"Invalid student id");
        }

        return new StudentResponseDto(student1.get());
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
        return studentResponseDtoList;
    }

    @Override
    public StudentResponseDto UpdateStudent(StudentRequestDto studentRequestDto) {
        Optional<Student> student = studentRepository.findById(studentRequestDto.getStudentId());
        if(student.isEmpty()){
            throw new StudentNotFoundException(studentRequestDto.getStudentId(),"Invalid Student id");
        }
        return new StudentResponseDto(student.get());
    }

    @Override
    public void DeleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException(id,"Invalid Student id");
        }
        studentRepository.delete(student.get());
    }
}