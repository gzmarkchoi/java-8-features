package com.mci.javaeight.stream;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.Optional;

public class StreamFindAnyFirstExample {

    public static Optional<Student> findAnyStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.7)
                .findAny();
    }

    public static Optional<Student> findFirstStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 4)
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<Student> studentOptionalFindAny = findAnyStudent();
        if (studentOptionalFindAny.isPresent()) {
            System.out.println("Found the student: " + studentOptionalFindAny.get());
        }

        Optional<Student> studentOptionalFindFirst = findFirstStudent();
        if (studentOptionalFindFirst.isPresent()) {
            System.out.println("Found first student: " + studentOptionalFindFirst.get());
        } else {
            System.out.println("Student not found");
        }
    }
}
