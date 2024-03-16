package com.cs401.mpp.model;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person {

    private String studentId;
    private LocalDate dateOfBirth;
    private LocalDate enrollmentDate;

    private List<Enrollment> enrollments;


    public Student(String studentId, LocalDate dateOfBirth, LocalDate enrollmentDate, String firstName, String lastName, String phoneNo, String email, Address address) {
        super(firstName, lastName, phoneNo, email, address);
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudentId() {
        return studentId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}
