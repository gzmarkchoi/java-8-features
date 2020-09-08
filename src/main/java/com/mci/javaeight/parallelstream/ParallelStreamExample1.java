package com.mci.javaeight.parallelstream;

import com.mci.javaeight.data.Student;
import com.mci.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample1 {
    public static List<String> sequentialPrintStudentActivities() {
        long startTime = System.currentTimeMillis();

        List<String> studentActivities = StudentDataBase.getAllStudents().stream() // stream<Student>
                .map(Student::getActivities)// stream<String> - stateless
                .flatMap(List::stream) // stream<String> - stateless
                .distinct() // stateful
                .sorted() // stateful
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration of execute the pipeline in sequential: " + (endTime - startTime));

        return studentActivities;
    }

    public static List<String> parallelPrintStudentActivities() {
        long startTime = System.currentTimeMillis();

        List<String> studentActivities = StudentDataBase.getAllStudents().stream() // stream<Student>
                .parallel()
                .map(Student::getActivities)// stream<String> - stateless
                .flatMap(List::stream) // stream<String> - stateless
                .distinct() // stateful
                .sorted() // stateful
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Duration of execute the pipeline in parallel: " + (endTime - startTime));

        return studentActivities;
    }

    public static void main(String[] args) {
        sequentialPrintStudentActivities();
        parallelPrintStudentActivities();
    }
}
