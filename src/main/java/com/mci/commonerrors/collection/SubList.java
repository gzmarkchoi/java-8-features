package com.mci.commonerrors.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubList {

    private static List<List<Integer>> data = new ArrayList<>();

    private static void wrong() {
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> subList = list.subList(1, 4);
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        subList.forEach(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        // wrong();
        // oom();
        // oomFix();
        right();

    }

    private static void oom (){
        for (int i = 0; i< 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0, 1));
        }
        System.out.println(data);
    }

    private static void oomFix (){
        for (int i = 0; i< 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(new ArrayList<>(rawList.subList(0, 1)));
        }
        System.out.println(data);
    }

    private static void right() {
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> subList = new ArrayList<>(list.subList(1, 4));
        System.out.println("Sublist: " + subList);
        subList.remove(1);
        System.out.println("List: " + list);
        list.add(0);
        subList.forEach(System.out::println);
    }
}
