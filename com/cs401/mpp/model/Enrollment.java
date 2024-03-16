package com.cs401.mpp.model;

public class Enrollment {

    private String grade;
    private Student student;
    private Section section;


    public Enrollment(Student student, Section section, String grade) {
        this.student = student;
        this.section = section;
        this.grade = grade;
    }


    public String getGrade() {
        return grade;
    }

    public Section getSection() {
        return section;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return String.format("Grade: %s", grade);

    }
}
