package com.cs401.mpp.model;

import java.util.List;

public class Admin extends Person {
    private String adminId;

    private List<Student> students;


    public Admin(String adminId, String firstName, String lastName, String phoneNo, String email, Address address, List<Student> students) {
        super(firstName, lastName, phoneNo, email, address);
        this.adminId = adminId;
        this.students = students;
    }

    public void addNewStudent(Student student) {
        // add student to student list
    }


    public void updateStudentInfo(Student student) {
        //get
    }

    public String getAdminId() {
        return adminId;
    }
}
