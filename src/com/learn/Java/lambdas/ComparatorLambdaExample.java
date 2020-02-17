package com.learn.Java.lambdas;

import javax.management.ListenerNotFoundException;
import java.util.*;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        /**
         * prior Java 8
         */
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        };

        System.out.println("Result of the comparator is: " + comparator.compare(3, 2));

        Comparator<Integer> comparatorLambda = (a, b) -> a.compareTo(b);
        System.out.println("Result of the comparator using Lambda is: " + comparatorLambda.compare(3, 2));

    }
}
