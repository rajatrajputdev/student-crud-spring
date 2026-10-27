package net.rajatrajputdev.studentApp.service;

import net.rajatrajputdev.studentApp.models.StudentEntity;
import net.rajatrajputdev.studentApp.repository.StudentAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentAppRepository studentAppRepository;

    public List<StudentEntity> getAllStudents(){
        return studentAppRepository.findAll();
    }

    public ResponseEntity<StudentEntity> getStudent(String studentEnrollment) {
        return studentAppRepository.findByStudentEnrollment(studentEnrollment)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public void saveStudent(StudentEntity studentEntity){
        studentAppRepository.insert(studentEntity);
    }

    public ResponseEntity<?> deleteStudent(String studentEnrollmentNumber){
        StudentEntity student = studentAppRepository.findByStudentEnrollment(studentEnrollmentNumber).orElse(null);
        if(student != null){
            studentAppRepository.delete(student);
            return new ResponseEntity<>("Student has been deleted from the database.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Student not found in the database.", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateStudent(StudentEntity studentEntity, String studentEnrollment){
        StudentEntity student = studentAppRepository.findByStudentEnrollment(studentEnrollment).orElse(null);
        if(student != null){
            student.setStudentEnrollment(studentEntity.getStudentEnrollment());
            student.setStudentName(studentEntity.getStudentName());
            student.setStudentCourse(studentEntity.getStudentCourse());
            student.setStudentBatch(studentEntity.getStudentBatch());
            student.setStudentEmail(studentEntity.getStudentEmail());
            student.setStudentPhone(studentEntity.getStudentPhone());
            student.setStudentDepartment(studentEntity.getStudentDepartment());
            student.setStudentGender(studentEntity.getStudentGender());
            student.setStudentCgpa(studentEntity.getStudentCgpa());
            studentAppRepository.save(student);
            return new ResponseEntity<>("Student updated in the database.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Student not found in the database.", HttpStatus.NOT_FOUND);
    }
}

