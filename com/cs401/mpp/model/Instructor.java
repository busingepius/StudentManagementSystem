package com.cs401.mpp.model;

import java.time.LocalDate;
import java.util.List;

public class Instructor extends Person {
    private String instructorId;
    private List<Course> courses;
    private List<Section> sections;

    public Instructor(String firstName, String lastName, String phoneNo, String email, Address address) {
        super(firstName, lastName, phoneNo, email, address);
    }



    public String getInstructorId() {
        return instructorId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Section> getSections() {
        return sections;
    }
}
