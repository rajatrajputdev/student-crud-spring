package net.rajatrajputdev.studentApp.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.Data;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student-crud")
@Data
public class StudentEntity {

    @Id
    private ObjectId studentId;

    @NotBlank(message = "Student enrollment cannot be empty")
    @Indexed(unique = true)
    private String studentEnrollment;

    @NotBlank(message = "Student name cannot be empty")
    @Size(min = 2, max = 100, message = "Student name must be between 2 and 100 characters")
    private String studentName;

    @NotBlank(message = "Student course cannot be empty")
    private String studentCourse;

    @PositiveOrZero(message = "Student batch cannot be negative")
    private int studentBatch;

    @NotBlank(message = "Student email cannot be empty")
    @Email(message = "Please provide a valid email address")
    @Indexed(unique = true)
    private String studentEmail;

    @NotBlank(message = "Student phone cannot be empty")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must contain 10 to 15 digits, optionally preceded by +")
    private String studentPhone;

    @NotBlank(message = "Student department cannot be empty")
    private String studentDepartment;

    @NotBlank(message = "Student gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String studentGender;

    @NotNull(message = "Student CGPA is required")
    @Min(value = 0, message = "CGPA cannot be less than 0")
    @Max(value = 10, message = "CGPA cannot exceed 10")
    private Double studentCgpa;
}
