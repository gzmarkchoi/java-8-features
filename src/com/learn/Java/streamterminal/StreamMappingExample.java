package com.learn.Java.streamterminal;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamMappingExample {

    public static void main(String[] args) {
        List<String> nameList = StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName, toList()));

        Set<String> nameSet = StudentDataBase.getAllStudents().stream()
                .collect(mapping(Student::getName, toSet()));

        List<String> nameListUsingMap = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Students name list: " + nameList);
        System.out.println("Students name set: " + nameSet);
        System.out.println("Students name list using map(): " + nameListUsingMap);
    }
}
