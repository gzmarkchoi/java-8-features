package com.mci.javaeight.functionalInterfaces;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {
    Predicate<Student> predicateGrade = (student) -> student.getGradeLevel() >= 3;
    Predicate<Student> predicateGpa = (student) -> student.getGpa() >= 3.9;

    BiPredicate<Integer, Double> biPredicateGradeGpa = (gradeLever, gpa) -> gradeLever >= 3 && gpa >= 3.9;

    // BiConsumer for name and activities
    BiConsumer<String, List<String>> studentBiConsumerNameActivities = (name, activities) -> System.out.println(name + ": " + activities);

    // Using BiPredicate
    Consumer<Student> studentConsumerGradeGpa = (student -> {
        if (biPredicateGradeGpa.test(student.getGradeLevel(), student.getGpa())) {
            studentBiConsumerNameActivities.accept(student.getName(), student.getActivities());
        }
    });

    // BiConsumer for name and grade
    BiConsumer<String, Integer> studentBiConsumerNameGrade = (name, grade) -> System.out.println(name + ": " + grade);

    // Using single Predicate
    Consumer<Student> studentConsumerGrade = (student -> {
        if (predicateGrade.test(student)) {
            studentBiConsumerNameGrade.accept(student.getName(), student.getGradeLevel());
        }
    });

    // print name and activities
    public void printNameAndActivities(List<Student> students) {
        students.forEach(studentConsumerGradeGpa);
    }

    // print name and grade
    public void printNameAndGrade(List<Student> students) {
        students.forEach(studentConsumerGrade);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("Students name and activities filtered by predicate grade and GPA");
        new PredicateAndConsumerExample().printNameAndActivities(studentList);
        System.out.println("Students name and grade filtered by predicate grade");
        new PredicateAndConsumerExample().printNameAndGrade(studentList);
    }
}
