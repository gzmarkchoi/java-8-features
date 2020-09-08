package com.mci.javaeight.stream;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComparatorExample {
    public static List<Student> sortStudentsByName() {
         return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGpa() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGpaDesc() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public  static List<Student> sortStudentsByGradeDesc() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGradeLevel).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("Students sorted by name: ");
        sortStudentsByName().forEach(System.out::println);

        System.out.println("---------------------------------------------------------");
        System.out.println("Students sorted by GPA: ");
        sortStudentsByGpa().forEach(System.out::println);

        System.out.println("---------------------------------------------------------");
        System.out.println("Students sorted by GPA DESC: ");
        sortStudentsByGpaDesc().forEach(System.out::println);

        System.out.println("---------------------------------------------------------");
        System.out.println("Students sorted by Grade level DESC: ");
        sortStudentsByGradeDesc().forEach(System.out::println);
    }
}
