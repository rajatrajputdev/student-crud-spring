package net.rajatrajputdev.studentApp.repository;

import net.rajatrajputdev.studentApp.models.StudentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentAppRepository extends MongoRepository<StudentEntity, ObjectId> {
    Optional<StudentEntity> findByStudentEnrollment(String studentEnrollment);
}
