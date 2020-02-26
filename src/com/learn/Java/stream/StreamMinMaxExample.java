package com.learn.Java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {
    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
            .reduce(0, (x, y) -> x > y ? x : y);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((x, y) -> x < y ? x : y);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((x, y) -> x > y ? x : y);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        int maxValue = findMaxValue(integerList);
        System.out.println("max value is: " + maxValue);

        Optional<Integer> minValueOptional = findMinValueOptional(integerList);
        System.out.println("min value using optional: " + minValueOptional.get());

        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);
        if(maxValueOptional.isPresent()) {
            System.out.println("Max value using optional: " + maxValueOptional.get());
        }
    }
}
