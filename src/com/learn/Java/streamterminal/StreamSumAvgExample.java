package com.learn.Java.streamterminal;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamSumAvgExample {
    public static int sum() {
        return StudentDataBase.getAllStudents().stream()
                .collect(summingInt(Student::getNoteBooks));
    }

    public static double average() {
        return StudentDataBase.getAllStudents().stream()
                .collect(averagingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {
        System.out.println("Total note books of all students: " + sum());
        System.out.println("Average note books of all students: " + average());
    }
}
