package net.rajatrajputdev.studentApp.repository;

import net.rajatrajputdev.studentApp.models.StudentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentAppRepository extends MongoRepository<StudentEntity, ObjectId> {
}
