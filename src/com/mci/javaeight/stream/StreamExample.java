package com.mci.javaeight.stream;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {

        Predicate<Student> studentGradePredicate = (student -> student.getGradeLevel() >= 3);
        Predicate<Student> studentGpaPredicate = (student -> student.getGpa() >= 3.9);

        Map<String, List<String>> studentMapNoFilterNameActivities = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        Map<String, Integer> studentMapFilterNameGrade = StudentDataBase.getAllStudents().stream()
                .filter(studentGradePredicate)
                .collect(Collectors.toMap(Student::getName, Student::getGradeLevel));

        Map<String, Double> studentMapFilterNameGpa = StudentDataBase.getAllStudents().stream()
                // use peek for debug
                .peek((student -> {
                    System.out.println("Name: " + student.getName() + " and GPA score: " + student.getGpa());
                }))
                .filter(studentGpaPredicate)
                .collect(Collectors.toMap(Student::getName, Student::getGpa));

        System.out.println("----------- Students without filter, print name and activities ----------- ");
        System.out.println(studentMapNoFilterNameActivities);

        System.out.println("----------- Students with grade filter, print name and grade ----------- ");
        System.out.println(studentMapFilterNameGrade);

        System.out.println("----------- Students with GPA filter, print name and GPA score ----------- ");
        System.out.println(studentMapFilterNameGpa);
    }
}
