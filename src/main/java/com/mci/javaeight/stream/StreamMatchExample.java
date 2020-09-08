package com.mci.javaeight.stream;

import com.mci.javaeight.data.StudentDataBase;

public class StreamMatchExample {
    public static boolean allMatch() {
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa() >= 3.5);
    }

    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() >= 4.0);
    }

    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa() >= 4.0);
    }

    public static void main(String[] args) {
        System.out.println("Result of all match: " + allMatch());
        System.out.println("Result of any match: " + anyMatch());
        System.out.println("Result of none match: " + noneMatch());
    }
}
