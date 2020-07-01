package com.mci.javaeight.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {
    public static Optional<Integer> limit(List<Integer> integers) {
        return integers.stream() // 6, 7, 8, 9, 10
                .limit(2) // only using first 2 elements: 6, 7
                .reduce((x, y) -> x + y);
    }

    public static Optional<Integer> skip(List<Integer> integers) {
        return integers.stream() // 6, 7, 8, 9, 10
                .skip(3) // skip the first 3 elements 9, 10
                .reduce((x, y) -> x + y);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);

        Optional<Integer> limitResult = limit(integerList);
        if (limitResult.isPresent()) {
            System.out.println("The limit result is: " + limitResult.get());
        }

        Optional<Integer> skipResult = skip(integerList);
        if (skipResult.isPresent()) {
            System.out.println("The skip result is: " + skipResult.get());
        }
    }
}
