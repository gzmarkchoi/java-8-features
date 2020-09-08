package com.mci.javaeight.stream;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static List<String> namesList() {
        List<String> studentNameList = StudentDataBase.getAllStudents().stream() // Stream<Student>
                // Student as an input -> Student name
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String> -> uppprecase on each input
                .collect(Collectors.toList());
        return studentNameList;
    }

    public static Set<String> namesSet() {
        Set<String> studentList = StudentDataBase.getAllStudents().stream() // Stream<Student>
                // Student as an input -> Student name
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String> -> uppprecase on each input
                .collect(Collectors.toSet());
        return studentList;
    }
    public static void main(String[] args) {
        System.out.println(namesList());
        System.out.println(namesSet());
    }
}
