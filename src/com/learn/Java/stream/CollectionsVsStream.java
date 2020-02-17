package com.learn.Java.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStream {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("adam");
        names.add("jim");
        names.add("jenny");

        for (String name: names) {
            System.out.println(name);
        }

        // names.remove(0);
        System.out.println(names);

        // read only operations
        Stream<String> nameStream = names.stream();
        // only can be traversed once
        nameStream.forEach(System.out::println);

    }
}
