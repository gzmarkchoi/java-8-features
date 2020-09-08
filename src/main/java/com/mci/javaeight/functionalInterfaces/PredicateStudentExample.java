package com.mci.javaeight.functionalInterfaces;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {
    static Predicate<Student> predicateGrade = (student -> student.getGradeLevel() >= 3);
    static Predicate<Student> predicateGpa = (student -> student.getGpa() >= 3.9);
    static List<Student> studentList = StudentDataBase.getAllStudents();

    public static void filterStudentsByGradeLevel() {
        System.out.println("filter students by grade level:");
        studentList.forEach(student -> {
            if (predicateGrade.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudentsByGpa() {
        System.out.println("filter students by GPA:");
        studentList.forEach(student -> {
            if (predicateGpa.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudents() {
        System.out.println("filter students by GPA and grade:");
        studentList.forEach(student -> {
            if (predicateGpa.and(predicateGrade).test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {
        filterStudentsByGradeLevel();
        filterStudentsByGpa();
        filterStudents();
    }
}
