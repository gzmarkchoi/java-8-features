package com.learn.Java.stream;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilterExample {

    private static Predicate<Student> predicateFemaleStudent = (student -> student.getGender().equals("female"));
    private static Predicate<Student> predicateGpa = (student -> student.getGpa() > 3.6);
    private static Predicate<Student> predicateGrade = (student -> student.getGradeLevel() > 3);

    public static List<Student> filterFemaleStudents() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter(predicateFemaleStudent) // Stream<Student> female
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> filterStudentsGpa() {
        return StudentDataBase.getAllStudents().stream()
                .filter(predicateGpa)
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public static List<Student> filterStudentsGradeLevel() {
        return StudentDataBase.getAllStudents().stream()
                .filter(predicateGrade)
                .sorted(Comparator.comparing(Student::getGradeLevel).reversed())
                .collect(Collectors.toList());
    }

    public static List<Student> filterStudentsFemaleGradeLevel() {
        return StudentDataBase.getAllStudents().stream()
                .filter(predicateFemaleStudent)
                .filter(predicateGrade)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Female students only");
        filterFemaleStudents().forEach(System.out::println);

        System.out.println("---------------------------------------");
        System.out.println("Students with GPA > 3.6");
        filterStudentsGpa().forEach(System.out::println);

        System.out.println("---------------------------------------");
        System.out.println("Students with grade level > 3");
        filterStudentsGradeLevel().forEach(System.out::println);

        System.out.println("---------------------------------------");
        System.out.println("Female students with grade level > 3");
        filterStudentsFemaleGradeLevel().forEach(System.out::println);
    }
}
