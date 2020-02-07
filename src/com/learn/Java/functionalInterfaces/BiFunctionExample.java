package com.learn.Java.functionalInterfaces;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunctionGpa = ((students, studentPredicate) -> {
        Map<String, Double> studentGpaMap = new HashMap<>();
        students.forEach(student -> {
            if(studentPredicate.test(student)) {
                studentGpaMap.put(student.getName(), student.getGpa());
            }
        });

        return studentGpaMap;
    });

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Integer>> biFunctionGrade = (((students, studentPredicate) -> {
        Map<String, Integer> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if(studentPredicate.test(student)) {
                studentGradeMap.put(student.getName(), student.getGradeLevel());
            }
        });

        return studentGradeMap;
    }));

    public static void main(String[] args) {
        // Student name and GPA
        System.out.println(biFunctionGpa.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.predicateGpa));
        // Student name and grade
        System.out.println(biFunctionGrade.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.predicateGrade));
    }
}
