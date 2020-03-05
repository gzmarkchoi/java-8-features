package com.learn.Java.streamterminal;

import com.learn.Java.data.StudentDataBase;

import static java.util.stream.Collectors.counting;

public class StreamCountingExample {
    public static long count() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .collect(counting());
    }

    public static void main(String[] args) {
        System.out.println("Total number of students with a GPA level: " + count());
    }
}
