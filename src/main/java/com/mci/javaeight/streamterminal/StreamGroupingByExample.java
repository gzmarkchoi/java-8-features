package com.mci.javaeight.streamterminal;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    public static void groupStudentsByGender() {
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGender));

        System.out.println("-------------------- Group students by gender --------------------");
        System.out.println(studentMap);
    }

    public static void groupStudentsByGenderGpa() {
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream() // Stream<Student>
                // Using lambda pour group Average GPA score or Outstanding score
                .collect(groupingBy(student -> student.getGpa() >= 3.8 ? "Outstanding" : "Average"));

        System.out.println("-------------------- Group students by GPA scores --------------------");
        System.out.println(studentMap);
    }

    public static void twoLevelGroupingGradeAndGpa() {
        Map<Integer, Map<String,List<Student>>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa() >= 3.8 ? "Outstanding" : "Average")));

        System.out.println("-------------------- Group students by Grade level and GPA scores --------------------");
        System.out.println(studentMap);
    }

    public static void twoLevelGroupingNameAndNotebook() {
        Map<String, Integer> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName,
                        summingInt(Student::getNoteBooks)));

        System.out.println("-------------------- Group students by name and number of notebooks --------------------");
        System.out.println(studentMap);
    }

    public static void threeArgumentGroupBy() {
        LinkedHashMap<String, Set<Student>> studentLinkedHashMap = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));

        System.out.println(studentLinkedHashMap);
    }

    public static void calculateTopGpa() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        maxBy(Comparator.comparing(Student::getGpa))));

        // System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptionalMaxGpa = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));

        System.out.println("-------------------- Group students by GPA score max -> min --------------------");
        System.out.println(studentMapOptionalMaxGpa);
    }

    public static void calculateLeaseGpa() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        minBy(Comparator.comparing(Student::getGpa))));

        // System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptional2 = StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(minBy(Comparator.comparing(Student::getGpa)), Optional::get)));

        System.out.println(studentMapOptional2);
    }

    public static void main(String[] args) {
        groupStudentsByGender();
        groupStudentsByGenderGpa();
        twoLevelGroupingGradeAndGpa();
        twoLevelGroupingNameAndNotebook();
        // threeArgumentGroupBy();
        calculateTopGpa();
        calculateLeaseGpa();
    }
}
