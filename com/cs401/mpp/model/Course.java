package com.cs401.mpp.model;

public class Course {
    private String courseId;
    private String name;
    private String description;
    private int credit;

    public Course(String courseId, String name, String description, int credit) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.credit = credit;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return String.format("Course Id: %s, Course Name: %s, Credits: %s", courseId, name, credit);

    }
}
