package com.learn.Java.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

    public static List<Integer> mapToObj() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj((i) -> i)
                .collect(Collectors.toList());
    }

    public static long mapToLong() {
        return IntStream.rangeClosed(1, 5) // intStream
                .mapToLong((i) -> i) // convert intStream to longStream
                .sum();
    }

    public static double mapToDouble() {
        return IntStream.rangeClosed(1, 5) // intStream
                .mapToDouble((i) -> i) // convert intStream to doubleStream
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Stream mapToObj(): " + mapToObj());
        System.out.println("Stream mapToLong(): " + mapToLong());
        System.out.println("Stream mapToDouble(): " + mapToDouble());
    }
}
