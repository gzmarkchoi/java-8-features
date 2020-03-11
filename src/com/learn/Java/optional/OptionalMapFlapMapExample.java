package com.learn.Java.optional;

import com.learn.Java.data.Bike;
import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import java.sql.SQLOutput;
import java.util.Optional;

public class OptionalMapFlapMapExample {
    // Optional filter
    public static void optionalFilter() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        System.out.println("----------------- Optional filter -----------------");
        studentOptional.filter(student -> student.getGpa() >= 3)
                .ifPresent(student -> System.out.println(student));
    }

    // Optional filter map
    public static void optionalMapStudentName() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        if(studentOptional.isPresent()) {
            Optional<String> name = studentOptional.filter(student -> student.getGpa() >= 3.5)
                    .map(Student::getName);

            System.out.println("----------------- Optional filter Map -----------------");
            System.out.println(name.get());
        }
    }

    // Optional filter flatMap
    public static void optionalFlatMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); // optional<Student>

        Optional<String> name = studentOptional.filter(student -> student.getGpa() >= 3.5) // Optional<Student>
                .flatMap(Student::getBike) // Optional<Bike>
                .map(Bike::getName);

        System.out.println("----------------- Optional filter flapMap -----------------");
        name.ifPresent(s -> System.out.println("bike name: " + s));
    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMapStudentName();
        optionalFlatMap();
    }
}
