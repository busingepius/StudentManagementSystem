package com.cs401.mpp;

import com.cs401.mpp.model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by: Pius and Phone
 * Year : 2024
 * Date : 15/03/2024
 * Time : 16:14
 *
 */

public class Main {

    public static List<Address> adList = loadAddress();
    public static List<Instructor> instructors = loadInstructor();
    public static List<Student> students = LoadStudents();
    public static List<Course> courses = loadCourses();
    public static List<Section> sections = loadSections();
    public static List<Enrollment> enrollments = loadEnrollment();

    static Scanner sc = new Scanner(System.in);


    //    Please login to the system by entering the specified Student Id: S0001
//
//    Welcome {{admin}}
//    1. Add New Student
//    2. Update Student Info


//    Please login to the system by entering the specified Student Id: S0001
//
//    Welcome Aye Aye!
//            1. Register Course
//2. View enroll courses
//
//    Please choose the action you want to do: 1
    // Please Choose Month
    // 1. APRIL
    // 2. MAY
    // 3. JUNE

    //if already registered in specified month
    //You have already registered this {{course}} in {{month}}
    //please choose another month

    // 1.2 Available Courses in {{month}}
    // Course Name   Instructor
    // 1. MPP        OBENA KALU
    // 2. MWA        Rujuan Xing
    // 3. WAA        Burmaa


    public static void main(String[] args) {
        System.out.println("Student Management System");
        System.out.println();


        System.out.println("Please Login");
        System.out.println("1. Admin");
        System.out.println("2. Student");

        System.out.println("Please choose the login role:");
        var roleId = sc.nextInt();

        switch (roleId) {
            case 1:
                break;
            case 2:
                loadStudentList();
                break;
            default:
                System.out.println("Default");
                break;

        }


        System.out.println("Please login to the system by entering the specified Student Id:");

        var stdId = sc.next();
        stdId = stdId.toUpperCase();
        var student = findStudentById(stdId);
        if (student.isEmpty()) {
            System.out.println("Student Id Not Found.");
            return;
        }

        System.out.printf("Welcome %s \n", student.get().getFullName());

        System.out.println("1. View Enrolled courses");
        System.out.println("2. Register Course");

        var stdAction = sc.nextInt();
        switch (stdAction) {
            case 1:
                viewEnrollCourses(stdId);
                break;
            case 2:
                registerCourse();
                break;
            default:
                System.out.println("Default");
                break;
        }


    }

    private static void loadAdminList() {

    }
    private static void loadStudentList() {
        System.out.println("Student List:");
        System.out.println("Student Id\t\tName");
        students.forEach(s -> System.out.printf("%s\t\t\t%s %s \n", s.getStudentId(), s.getFirstName(), s.getLastName()));
    }

    // Please Choose Month
    // 1. APRIL
    // 2. MAY
    // 3. JUNE

    //if already registered in specified month
    //You have already registered this {{course}} in {{month}}
    //please choose another month

    // 1.2 Available Courses in {{month}}
    // Course Name   Instructor
    // 1. MPP        OBENA KALU
    // 2. MWA        Rujuan Xing
    // 3. WAA        Burmaa

    private static void registerCourse() {

        System.out.println("Please Choose Month");
        // get available months from section
        List<String> availableMonths = sections
                .stream()
                .map(s -> s.getStartDate().getMonth().toString())
                .distinct()
                .toList();

        //Print to the console
        int count = 0;
        for (String month : availableMonths) {
            System.out.printf("%d. %s \n", ++count, month);
        }

        //get month input from user
        var month = sc.nextInt();
        // convert input integer month to string display month
        String inputMonth = availableMonths.get(--month);


        // show taught causes by month
        System.out.printf("Available Courses in %s \n", inputMonth);
        System.out.println("SectionId \t\t Course Name \t\t Instructor");

//
        sections.stream()
                .filter(s -> s.getStartDate().getMonth().toString().equals(inputMonth))
                .forEach(s -> {
                    System.out.printf("%s \t\t\t %s \t\t\t\t %s \n", s.getSectionId(), s.getCourse().getName(), s.getInstructor().getFullName());

                });


    }

    private static void viewEnrollCourses(String stdId) {

        System.out.println("Course Id \t Course Name \t Credits \t Grade");


        enrollments.stream()
                .filter(e -> e.getStudent().getStudentId().equals(stdId))
                .forEach(e -> {
                    Course course = e.getSection().getCourse();
                    System.out.printf("%s \t\t %s \t\t\t %s \t\t\t %s \n",
                            course.getCourseId(), course.getName(), course.getCredit(), e.getGrade());
                });
    }

    private static Optional<Student> findStudentById(String id) {
        return students.stream().filter(s -> s.getStudentId().equals(id)).findFirst();
    }


    public static List<Address> loadAddress() {
        List<Address> Addresss = new ArrayList<>();
        var a1 = new Address("802 N", "Fairfield", "IA", "52556");
        var a2 = new Address("1000 N", "Fairfield", "IA", "52557");

        Addresss.add(a1);
        Addresss.add(a2);
        return Addresss;

    }

    public static List<Instructor> loadInstructor() {

        List<Instructor> instructors = new ArrayList<>();

        var p1 = new Instructor("Obinna", "Kalu", "6412339333", "obinna.kalu@miu.edu", adList.get(0));
        var p2 = new Instructor("Burmaa", "Enkhbat", "3192339366", "burmaa@miu.edu", adList.get(1));
        var p3 = new Instructor("Rujuan", "Xing", "6411339722", "rujuan@miu.edu", adList.get(1));
        var p4 = new Instructor("Sridevi", "Malasani", "6412339462", "sridevi@miu.edu", adList.get(1));

        instructors.add(p1);
        instructors.add(p2);
        instructors.add(p3);
        instructors.add(p4);

        return instructors;
    }

    public static List<Student> LoadStudents() {
        List<Student> students = new ArrayList<>();


        var s1 = new Student("STD01", LocalDate.of(1998, 8, 11)
                , LocalDate.of(2023, 2, 20), "John", "Mike", "3197263847", "John@miu.edu", adList.get(0));

        var s2 = new Student("STD02", LocalDate.of(1992, 4, 20)
                , LocalDate.of(2022, 2, 10), "Busing", "Pius", "6412339423", "pius@miu.edu", adList.get(1));

        students.add(s1);
        students.add(s2);
        return students;

    }

    public static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        var c1 = new Course("CS390", "FPP", "Functional Programming Practice", 3);
        var c2 = new Course("CS401", "MPP", "Modern Programming Practice", 4);
        var c3 = new Course("CS405", "WAP", "Web Application Programming", 4);
        var c4 = new Course("CS545", "WAA", "Web Application Architecture", 4);

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        return courses;

    }

    public static List<Enrollment> loadEnrollment() {
        List<Enrollment> enrollments = new ArrayList<>();
        var e1 = new Enrollment(students.get(0), sections.get(0), "B");
        var e2 = new Enrollment(students.get(1), sections.get(0), "A");
        var e3 = new Enrollment(students.get(0), sections.get(1), "B");
        enrollments.add(e1);
        enrollments.add(e2);
        enrollments.add(e3);
        return enrollments;
    }

    public static List<Section> loadSections() {

        List<Section> sections = new ArrayList<>();
        //FPP
        var s1 = new Section("SEC01", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 31),
                courses.get(0), loadInstructor().get(0));
        //MPP
        var s2 = new Section("SEC02", LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 31),
                courses.get(1), loadInstructor().get(1));
        //WAP
        var s3 = new Section("SEC03", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30),
                courses.get(2), loadInstructor().get(2));
        var s4 = new Section("SEC04", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30),
                courses.get(2), loadInstructor().get(3));
        //WAA
        var s5 = new Section("SEC05", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30),
                courses.get(3), loadInstructor().get(1));

        sections.add(s1);
        sections.add(s2);
        sections.add(s3);
        sections.add(s4);
        sections.add(s5);

        return sections;

    }


}
