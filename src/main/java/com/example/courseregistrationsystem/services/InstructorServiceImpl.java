package com.example.courseregistrationsystem.services;

<<<<<<< HEAD
public class InstructorServiceImpl {
=======
import com.example.courseregistrationsystem.dtos.InstructorRequestDto;
import com.example.courseregistrationsystem.dtos.InstructorResponseDto;
import com.example.courseregistrationsystem.exceptions.*;
import com.example.courseregistrationsystem.models.Admin;
import com.example.courseregistrationsystem.models.Course;
import com.example.courseregistrationsystem.models.Department;
import com.example.courseregistrationsystem.models.Instructor;
import com.example.courseregistrationsystem.repositories.AdminRepository;
import com.example.courseregistrationsystem.repositories.CourseRepository;
import com.example.courseregistrationsystem.repositories.DepartmentRepository;
import com.example.courseregistrationsystem.repositories.InstructorRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{
    private final DepartmentRepository departmentRepository;
    private InstructorRepository InstructorRepository;
    private CourseRepository CourseRepository;
    private AdminRepository AdminRepository;
    private DepartmentRepository DepartmentRepository;
    public InstructorServiceImpl(InstructorRepository InstructorRepository, CourseRepository CourseRepository, AdminRepository repo, DepartmentRepository departmentRepository){
        this.InstructorRepository = InstructorRepository;
        this.CourseRepository = CourseRepository;
        this.AdminRepository = repo;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public InstructorResponseDto getInstructorById(Long id) {
        Optional<Instructor> instr =  InstructorRepository.findById(id);
        if(instr.isEmpty()){
            throw new InstructorNotFound(id, "instructor not found");
        }
        return new InstructorResponseDto(instr.get());
    }

    @Override
    public List<InstructorResponseDto> getAllInstructors() {
        List<Instructor> instr =  InstructorRepository.findAll();
        List<InstructorResponseDto> instructorResponseDtos = new ArrayList<>();
        for(Instructor i : instr){
            instructorResponseDtos.add(new InstructorResponseDto(i));
        }
        return instructorResponseDtos;
    }

    @Override
    public InstructorResponseDto getInstructorByCourseId(Long id) {
        Optional<Course> course = CourseRepository.findById(id);
        if(course.isEmpty()){
            throw new CourseNotFoundExeption(id, "Course Not found");
        }
        return new InstructorResponseDto(course.get().getInstructor());
    }

    @Override
    public List<InstructorResponseDto> getInstructorByDepartmentId(Long id) {
        Optional<Department> department = DepartmentRepository.findById(id);
        if(department.isEmpty()){
            throw new DepartmentNotFoundException(id, "Department Not found");
        }
        List<Course> course = department.get().getCourses();
        List<InstructorResponseDto> list = new ArrayList<>();
        for(Course i : course){
            list.add(getInstructorByCourseId(i.getCourseId()));
        }
        return list;
    }

    @Override
    public InstructorResponseDto createInstructor(InstructorRequestDto instructor) {
        if(!instructor.check()){
            throw new BadRequest("Please Send all the details correctly");
        }
        Instructor inst = new Instructor();
        Optional<Department> dpr = departmentRepository.findById(instructor.getDepartmentId());
        if(dpr.isEmpty()){
            throw new DepartmentNotFoundException(instructor.getInstructorId(), " Department not found");
        }
        inst.setDepartment(dpr.get());
        inst.setName(instructor.getName());
        inst.setTitle(instructor.getTitle());
        return new InstructorResponseDto(inst);
    }

    @Override
    public InstructorResponseDto updateInstructor(InstructorRequestDto instructor) {
        if(!instructor.check()){
            throw new BadRequest("Please Send all the details correctly");
        }
        Optional<Admin> admin = AdminRepository.findById(instructor.getAdminUsername());
        if(admin.isEmpty()){
            throw new AdminNotFound(instructor.getAdminUsername(), "No admin with this username");
        }
        Admin admin2 = admin.get();
        if(admin2.getAdmin_Password()!=instructor.getPassword()){
            throw new AdminNotFound(instructor.getAdminUsername(), "Wrong password");
        }
        Optional<Instructor> instruct = InstructorRepository.findById(instructor.getInstructorId());
        if(instruct.isEmpty()){
            throw new InstructorNotFound(instructor.getInstructorId(), "wrong id");
        }
        Instructor inst = new Instructor();
        Optional<Department> dpr = departmentRepository.findById(instructor.getDepartmentId());
        if(dpr.isEmpty()){
            throw new DepartmentNotFoundException(instructor.getInstructorId(), " Department not found");
        }
        inst.setDepartment(dpr.get());
        inst.setName(instructor.getName());
        inst.setTitle(instructor.getTitle());
        return null;
    }

    @Override
    public void deleteInstructor(@RequestBody InstructorRequestDto instructor) {
        Optional<Instructor> inst = InstructorRepository.findById(instructor.getInstructorId());
        if(inst.isEmpty()){
            throw new InstructorNotFound(instructor.getInstructorId(), "Instructor not found");
        }
        Optional<Admin> admin = AdminRepository.findById(instructor.getAdminUsername());
        if(admin.isEmpty()){
            throw new AdminNotFound(instructor.getAdminUsername(), "Admin not found");
        }
        if(admin.get().getAdmin_Password().equals(instructor.getPassword())){
            InstructorRepository.delete(inst.get());
        }else{
            throw new AdminNotFound(instructor.getAdminUsername(), "Wrong Password");
        }
    }
>>>>>>> 6d1d63bcbfe3efcbb6d09c06da87b618d9a7f890
}
