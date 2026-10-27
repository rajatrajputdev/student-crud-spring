package net.rajatrajputdev.studentApp.controller;

import net.rajatrajputdev.studentApp.models.StudentEntity;
import net.rajatrajputdev.studentApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-students")
    public ResponseEntity<List<StudentEntity>> getStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/get-student/{studentEnrollmentNumber}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable String studentEnrollmentNumber){
        return studentService.getStudent(studentEnrollmentNumber)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
