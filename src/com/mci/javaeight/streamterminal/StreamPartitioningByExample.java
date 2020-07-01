package com.mci.javaeight.streamterminal;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPartitioningByExample {
    public static void partitioningByWithList() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
        Map<Boolean, List<Student>> partitioningMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate));

        System.out.println("partitioning map with List: "+ partitioningMap);
    }

    public static void partitioningByWithSet() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
        Map<Boolean, Set<Student>> partitioningMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));

        System.out.println("partitioning map with Set: "+ partitioningMap);
    }

    public static void main(String[] args) {
        partitioningByWithList();
        partitioningByWithSet();
    }
}
