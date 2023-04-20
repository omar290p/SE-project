package src;

import java.util.LinkedList;
import java.util.Scanner;

public class IT extends Staff {

    static LinkedList<Student> allStudents = new LinkedList<>();
    static LinkedList<Course> allCourses = new LinkedList<>();
    static LinkedList<Teacher> allTeachers = new LinkedList<>();

    public IT() {
        super();
    }

    public IT(double salary, String experience, String certificates) {
        super(salary, experience, certificates);
    }

    public IT(String name, String phoneNumber, Account account, double salary, String experience, String certificates) {
        super(name, phoneNumber, account, salary, experience, certificates);
    }

//    public IT(String name, String phoneNumber, Account account, LinkedList<Attendance> attendance, double salary, String experience, String certificates) {
//        super(name, phoneNumber, account, attendance, salary, experience, certificates);
//    }

    public void addTeacher(Teacher t){
        allTeachers.add(t);
    }

    public void removeTeacher(Teacher t){
        if(!(allTeachers.contains(t))){
            System.out.println("Teacher not found");
        }
        allTeachers.remove(t);
    }

    public void assignTeacherToCourse(Teacher t,Course c){
        c.setCourseDoctor(t);
    }

    public void unassignTeacherToCourse(Course c){
        c.setCourseDoctor(null);
    }

    public static LinkedList<Teacher> getAllTeachers() {
        return allTeachers;
    }

    public static void setAllTeachers(LinkedList<Teacher> allTeachers) {
        IT.allTeachers = allTeachers;
    }

    void addCourse(Course c){
        allCourses.add(c);
    }

    void removeCourse(Course c){
        if(!(allCourses.contains(c))){
            System.out.println("Course not found");
        }
        else{
            allCourses.remove(c);
        }
    }

    void addStudent(Student s){
        allStudents.add(s);
    }

    void removeStudent(Student s){
        if(!(allStudents.contains(s))){
            System.out.println("Student not found");
        }
        else{
            allStudents.remove(s);
        }
    }

    public boolean enrollStudentToCourse(Student student, Course course){
        if(!(allStudents.contains(student) && allCourses.contains(course))){
            return false;
        }
        student.getCourses().add(course);
        return true;
    }
    public boolean removeStudentFromCourse(Student student, Course course){
        return student.getCourses().remove(course);
    }

    public boolean isEnrolledToCourse(Student student, Course course){
        return allStudents.contains(student) && allCourses.contains(course);
    }

    public static LinkedList<Student> getAllStudents() {
        return allStudents;
    }

    public static void setAllStudents(LinkedList<Student> allStudents) {
        IT.allStudents = allStudents;
    }

    public static LinkedList<Course> getAllCourses() {
        return allCourses;
    }

    public static void setAllCourses(LinkedList<Course> allCourses) {
        IT.allCourses = allCourses;
    }

    public boolean manageStudents(Student student, Course course){
        if(!(isEnrolledToCourse(student, course))){
            return false;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enroll to course? or remove from course?: 0, 1");
        int choice = input.nextInt();

        switch (choice) {
            case 0 -> enrollStudentToCourse(student, course);
            case 1 -> removeStudentFromCourse(student, course);
            default -> {
                System.out.println("undefined input!! terminating function");
                return false;
            }
        }

        return true;
    }

}
