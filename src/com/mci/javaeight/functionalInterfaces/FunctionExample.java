package com.mci.javaeight.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {
    // Perform upper case
    static Function<String, String> function = (name) -> name.toUpperCase();

    static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat(" default");

    public static void main(String[] args) {
        System.out.println("Result is: " + function.apply("java8"));

        // and then
        System.out.println("Result is: " + function.andThen(addSomeString).apply("java8"));

        // compose
        System.out.println("Result is: " + function.compose(addSomeString).apply("java8"));
    }
}
