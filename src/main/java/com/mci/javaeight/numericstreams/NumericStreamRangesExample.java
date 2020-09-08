package com.mci.javaeight.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {
    public static void main(String[] args) {
        // It stops at 49
        IntStream intStream = IntStream.range(1, 50);
        System.out.println(intStream.count());

        System.out.println("Range count " + IntStream.range(1, 50).count());
        IntStream.range(1, 50).forEach((value -> System.out.print(value + ",")));

        System.out.println();

        System.out.println("Range closed count " + IntStream.rangeClosed(1, 50).count());
        IntStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ","));

        System.out.println();
        System.out.println("Long stream closed count " + LongStream.rangeClosed(1, 50).count());
        LongStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ","));

        System.out.println();
        System.out.println("Double stream closed count " + IntStream.rangeClosed(1, 50).asDoubleStream().count());
        IntStream.range(1, 50).asDoubleStream().forEach(value -> System.out.print(value + ","));
    }
}
