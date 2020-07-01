package com.mci.javaeight.functionalInterfaces;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> studentConsumer = (student) -> System.out.println(student);
    static Consumer<Student> studentNameConsumer = (student) -> System.out.println("Name: " + student.getName());
    static Consumer<Student> studentActivityConsumer = (student) -> System.out.println("Activities: " + student.getActivities());
    static Consumer<Student> studentGrade = (student -> System.out.println("Grade: " + student.getGradeLevel()));
    static Consumer<Student> studentGPA = (student -> System.out.println("GPA: " + student.getGpa()));
    static List<Student> studentList = StudentDataBase.getAllStudents();

    public static void printName() {
        studentList.forEach(studentConsumer);
    }

    public static void printNameActivities() {
        studentList.forEach(studentNameConsumer.andThen(studentActivityConsumer)); // consumer chaining
    }

    public static void printNameActivitiesGradeUsingGrade() {
        System.out.println("method printNameActivitiesGradeUsingGrade");
        studentList.forEach((student -> {
            if(student.getGradeLevel() <= 3 && student.getGpa() <= 3.9) {
                studentNameConsumer.andThen(studentActivityConsumer).andThen(studentGrade).accept(student);
            }
        }));
    }

    public static void printNameGpa() {
        System.out.println("method printNameGpa");

        studentList.forEach((student -> {
            if(student.getGpa() >= 3.9) {
                studentNameConsumer.andThen(studentGPA).accept(student);
            }
        }));
    }

    public static void main(String[] args) {

        // printName();
        // printNameActivities();
        // printNameActivitiesGradeUsingGrade();
        printNameGpa();
    }
}
