package com.mci.javaeight.lambdas;

import java.util.function.Consumer;

public class LambdaVariable2 {
    public static void main(String[] args) {
        int value = 4;
        Consumer<Integer> consumer1 = (i) -> {
            // value++; not allow!
            System.out.println(value + i);
        };
        consumer1.accept(4);
    }
}
