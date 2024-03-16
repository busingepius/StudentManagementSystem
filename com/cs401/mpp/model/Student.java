/**
 * Created by: Phone and Pius
 * Year : 2024
 * Date : 16/03/2024
 * Time : 15:39
 * Project Name : com.cs401.mpp.model
 */
package com.cs401.mpp.model;

import java.time.LocalDate;

public class Student extends Person {
    private String studentID;
    private LocalDate enrollmentDate;

    public Student(
            String studentID, LocalDate enrollmentDate,
            String firstName, String lastName, String phoneNo, String email, LocalDate dateOfBirth,
            String street, String city, String state, String zip
    ) {
        super(firstName, lastName, phoneNo, email, dateOfBirth, street, city, state, zip);
        this.studentID = studentID;
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
