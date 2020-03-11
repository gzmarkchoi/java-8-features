package com.learn.Java.defaults;

import java.util.*;

public class DefaultMethodsExample {
    public static void main(String[] args) {
        // sort the list names in alphabetical order
        List<String> stringList = Arrays.asList("Adam", "Jenny", "Alex", "Dan", "Mike", "Eric");

        // Before Java 8
        Collections.sort(stringList);
        System.out.println("Sorted list using Collections.sort(): " + stringList);

        // Java 8
        stringList.sort(Comparator.naturalOrder());
        System.out.println("Sorted list using List.sort: " + stringList);

        stringList.sort(Comparator.reverseOrder());
        System.out.println("Sorted list using List.sort reverse: " + stringList);
    }
}
