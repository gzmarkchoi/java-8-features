package com.mci.javaeight.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {
    public static void main(String[] args) {
        System.out.println("------------------------- Stream of -------------------------");
        Stream<String> stringStream = Stream.of("adam", "dan", "julie");
        stringStream.forEach(System.out::println);

        System.out.println("------------------------- Stream iterate -------------------------");
        Stream.iterate(1, x -> x * 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("------------------------- Stream generate -------------------------");
        Supplier<Integer> integerSupplier = new Random()::nextInt;

        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}