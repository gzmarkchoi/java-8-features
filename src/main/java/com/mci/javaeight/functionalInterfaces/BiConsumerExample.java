package com.mci.javaeight.functionalInterfaces;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void nameAndActivities() {
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println("Name: " + name + ", and activities: " + activities);
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach((student -> biConsumer.accept(student.getName(), student.getActivities())));
    }

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a: " + a + " , b: " +b);
        };

        biConsumer.accept("java7", "java8");

        BiConsumer<Integer, Integer> multiply = (a, b) -> {
            System.out.println("Multiplication is: " + (a * b));
        };

        BiConsumer<Integer, Integer> division = (a, b) -> {
            System.out.println("Division is: " + (a / b));
        };

        multiply.accept(3, 4);
        multiply.andThen(division).accept(10, 5);

        nameAndActivities();
    }
}