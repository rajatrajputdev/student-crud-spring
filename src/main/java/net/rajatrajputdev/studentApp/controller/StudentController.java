package net.rajatrajputdev.studentApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.rajatrajputdev.studentApp.models.StudentEntity;
import net.rajatrajputdev.studentApp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@Tag(name = "Student CRUD API")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{studentEnrollmentNumber}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable String studentEnrollmentNumber){
        return studentService.getStudent(studentEnrollmentNumber);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentEntity studentEntity){
        studentService.saveStudent(studentEntity);
        return new ResponseEntity<>("Student added in the database.",HttpStatus.CREATED);
    }

    @DeleteMapping("/{studentEnrollmentNumber}")
    public ResponseEntity<?> deleteStudent(@PathVariable String studentEnrollmentNumber){
        return studentService.deleteStudent(studentEnrollmentNumber);
    }

    @PutMapping("/{studentEnrollmentNumber}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody StudentEntity studentEntity, @PathVariable String studentEnrollmentNumber){
        return studentService.updateStudent(studentEntity, studentEnrollmentNumber);
    }
}
