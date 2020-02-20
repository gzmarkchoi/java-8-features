package com.learn.Java.stream;

import com.learn.Java.data.Student;
import com.learn.Java.data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static int performMultiplication(List<Integer> integerList) {
        return integerList.stream()
                // 1
                // 3
                // 5
                // 7
                // a=1, b= 1(from stream) ->
                .reduce(1, (a, b) -> a * b );
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {
        return integerList.stream()
                // 1
                // 3
                // 5
                // 7
                // a=1, b= 1(from stream) ->
                .reduce((a, b) -> a * b );
    }

    public static Optional<Student> getHighestGPAStudent() {
        return StudentDataBase.getAllStudents().stream()
                // students one by one
                .reduce((student1, student2) -> student1.getGpa() > student2.getGpa() ? student1 : student2);
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);
        List<Integer> emptyIntegers = new ArrayList<>();

        System.out.println(performMultiplication(integers));

        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);
        System.out.println(result.isPresent());
        System.out.println(result.get());

        Optional<Integer> emptyResult = performMultiplicationWithoutIdentity(emptyIntegers);
        System.out.println(emptyResult.isPresent());
        if (emptyResult.isPresent()) {
            System.out.println(emptyResult.get());
        }

        Optional<Student> studentOptional = getHighestGPAStudent();
        if(getHighestGPAStudent().isPresent()) {
            System.out.println(studentOptional.get());
        }
    }
}
