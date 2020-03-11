package com.learn.Java.streamterminal;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamJoiningExample {
    public static String joining_1() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName) // Stream<String>
                .collect(Collectors.joining());
    }

    public static String joining_2() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName) // Stream<String>
                .collect(Collectors.joining("-"));
    }

    public static String joining_3() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName) // Stream<String>
                .collect(Collectors.joining("-", "(", ")"));
    }

    public static void main(String[] args) {
        System.out.println("joining 1: " + joining_1());
        System.out.println("joining 1: " + joining_2());
        System.out.println("joining 1: " + joining_3());
    }
}
