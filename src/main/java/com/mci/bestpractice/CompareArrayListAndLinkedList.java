package com.mci.bestpractice;

import java.util.*;

public class CompareArrayListAndLinkedList {
    static void testAddAtTail(List list, String type) {
        int size = 1000000;
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("test add at tail for " + type);
        System.out.println(end - start);
    }

    static void testRandomSearch(List list, String type) {
        Random rand = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.indexOf(rand.nextInt(100000));
        }
        long end = System.currentTimeMillis();
        System.out.println("test random search for " + type);
        System.out.println(end - start);
    }

    static void testAddAtRandom(List list, String type) {
        Random rand = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(100000), "0");
        }
        long end = System.currentTimeMillis();
        System.out.println("test add at random for " + type);
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        System.out.println("-----------------------------------------------------");
        System.out.println("--------     Addition at tail position       --------");
        testAddAtTail(arrayList, "ArrayList");
        testAddAtTail(linkedList, "LinkedList");

        System.out.println("-----------------------------------------------------");
        System.out.println("--------     Addition at random position     --------");
        testAddAtRandom(arrayList, "ArrayList");
        testAddAtRandom(linkedList, "LinkedList");

        System.out.println("-----------------------------------------------------");
        System.out.println("--------            Random search            --------");
        testRandomSearch(arrayList, "ArrayList");
        testRandomSearch(linkedList, "LinkedList");

        System.out.println("-----------------------------------------------------");
        LinkedList ll = new LinkedList();
        Iterator it = ll.iterator();
    }
}
