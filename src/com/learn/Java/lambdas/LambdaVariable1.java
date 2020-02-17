package com.learn.Java.lambdas;

import java.util.function.Consumer;

public class LambdaVariable1 {
    public static void main(String[] args) {
        // int i = 0; error
        Consumer<Integer> consumer1 = (i) -> System.out.println("Value is:" + i);
    }
}
