package com.mci.javaeight.functionalInterfaces;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {
    // filtered, print name and grade
    static Function<List<Student>, Map<String, Double>> studentFunctionFilteredByGrade = (students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach((student -> {
            if(PredicateStudentExample.predicateGrade.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        }));

        return studentGradeMap;
    });

    // No filter, print name and gender
    static Function<List<Student>, Map<String, String>> studentFunctionNoFilter = (students -> {
        Map<String, String> studentMap = new HashMap<>();
        students.forEach(student -> studentMap.put(student.getName(), student.getGender()));

        return studentMap;
    });

    public static void main(String[] args) {
        System.out.println(studentFunctionFilteredByGrade.apply(StudentDataBase.getAllStudents()));
        System.out.println(studentFunctionNoFilter.apply(StudentDataBase.getAllStudents()));
    }
}
