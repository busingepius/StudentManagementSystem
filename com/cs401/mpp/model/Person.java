package com.cs401.mpp.model;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private Address address;

    public Person(String firstName, String lastName, String phoneNo, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
