package com.learn.Java.methodreference;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {
    static Predicate<Student> predicateGradeLevel = RefactorMethodReferenceExample::greaterThanGradeLevel;

    public static boolean greaterThanGradeLevel(Student student) {
        return student.getGradeLevel() >= 3;
    }

    public static void main(String[] args) {
        System.out.println(predicateGradeLevel.test(StudentDataBase.studentSupplier.get()));
    }
}
