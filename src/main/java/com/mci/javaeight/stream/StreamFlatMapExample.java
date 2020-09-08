package com.mci.javaeight.stream;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static List<String> printStudentActivities() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .distinct() // Stream<String> -> with distinct function
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> printStudentNames() {
        return  StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public static long getStudentActivitiesCount() {
        return  StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .distinct() // Stream<String> -> with distinct function
                .count();
    }

    public static void main(String[] args) {
        System.out.println("All Students activities: " + printStudentActivities());
        System.out.println("Number of Students activities: " + getStudentActivitiesCount());

        System.out.println("All students names: " + printStudentNames());
    }
}
