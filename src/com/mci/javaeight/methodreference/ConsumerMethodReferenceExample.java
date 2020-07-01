package com.mci.javaeight.methodreference;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {
    // className::methodName
    static Consumer<Student> consumer1 = System.out::println;

    // className::instanceMethodName
    static Consumer<Student> consumer2 = Student::printListOfActivities;

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(consumer1);
        StudentDataBase.getAllStudents().forEach(consumer2);
    }
}
