package net.rajatrajputdev.studentApp.service;

import net.rajatrajputdev.studentApp.models.StudentEntity;
import net.rajatrajputdev.studentApp.repository.StudentAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentAppRepository studentAppRepository;

    public List<StudentEntity> getAllStudents(){
        return studentAppRepository.findAll();
    }

    public Optional<StudentEntity> getStudent(String studentEnrollment) {
        return studentAppRepository.findByStudentEnrollment(studentEnrollment);
    }


}

