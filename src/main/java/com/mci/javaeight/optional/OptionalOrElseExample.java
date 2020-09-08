package com.mci.javaeight.optional;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {
    // orElse
    public static String optionalOrElse() {
        Optional<Student> studentOptional =  Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> studentOptional =  Optional.ofNullable(null); // Option.empty
        String name = studentOptional.map(Student::getName).orElse("No student found");
        return name;
    }

    // orElseGet
    public static String optionalOrElseGet() {
        Optional<Student> studentOptional =  Optional.ofNullable(StudentDataBase.studentSupplier.get());
        String name = studentOptional.map(Student::getName).orElseGet(() -> "default");
        return name;
    }

    //orElseThrow
    public static String optionalOrElseThrow() {
        Optional<Student> studentOptional =  Optional.ofNullable(null);
        String name = studentOptional.map(Student::getName).orElseThrow(() -> new RuntimeException("No data available"));
        return name;
    }

    public static void main(String[] args) {
        System.out.println("orElse: " + optionalOrElse());
        System.out.println("orElseGet: " + optionalOrElseGet());
        System.out.println("orElseThrow: " + optionalOrElseThrow());
    }
}
