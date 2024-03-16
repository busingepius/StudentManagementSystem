/**
 * Created by: Phone and Pius
 * Year : 2024
 * Date : 16/03/2024
 * Time : 15:36
 * Project Name : com.cs401.mpp.model
 */
package com.cs401.mpp.model;

import java.time.LocalDate;

public class Instructor extends Person {
    private String instructorID;

    public Instructor(
            String instructorID,
            String firstName, String lastName, String phoneNo, String email, LocalDate dateOfBirth,
            String street, String city, String state, String zip) {
        super(firstName, lastName, phoneNo, email, dateOfBirth, street, city, state, zip);
        this.instructorID = instructorID;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }
}
