package com.cs401.mpp.model;

import java.time.LocalDate;

public class Section {
    private String sectionId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Course course;

    private Instructor instructor;

    public Section(String sectionId, LocalDate startDate, LocalDate endDate, Course course, Instructor instructor) {
        this.sectionId = sectionId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.instructor = instructor;
    }

    public String getSectionId() {
        return sectionId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }
}
