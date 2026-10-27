package net.rajatrajputdev.studentApp.controller;

import jakarta.validation.Valid;
import net.rajatrajputdev.studentApp.models.StudentEntity;
import net.rajatrajputdev.studentApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return studentService.getStudent(studentEnrollmentNumber);
    }

    @PostMapping("/create-student")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentEntity studentEntity){
        studentService.saveStudent(studentEntity);
        return new ResponseEntity<>("Student added in the database.",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-student/{studentEnrollmentNumber}")
    public ResponseEntity<?> deleteStudent(@PathVariable String studentEnrollmentNumber){
        return studentService.deleteStudent(studentEnrollmentNumber);
    }

    @PutMapping("/update-student/{studentEnrollmentNumber}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody StudentEntity studentEntity, @PathVariable String studentEnrollmentNumber){
        return studentService.updateStudent(studentEntity, studentEnrollmentNumber);
    }
}
