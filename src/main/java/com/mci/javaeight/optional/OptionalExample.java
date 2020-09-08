package com.mci.javaeight.optional;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {

    public static String getStudentName() {
        // traditional way
        Student student = StudentDataBase.studentSupplier.get();

        if(student != null) {
            return student.getName();
        }
        return null;
    }

    public static Optional<String> getStudentNameOptional() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        // Optional<Student> studentOptional = Optional.ofNullable(null);

        if(studentOptional.isPresent()) {
            return studentOptional.map(Student::getName); // Optional<String>
        }

        return Optional.empty(); // Optional with no value
    }

    public static void main(String[] args) {
        String name = getStudentName();
        // System.out.println("Student name: " + name);

        Optional<String> stringOptional = getStudentNameOptional();
        if(stringOptional.isPresent()) {
            System.out.println("Name of student: " + stringOptional.get());
        } else {
            System.out.println("No student found");
        }
    }
}
