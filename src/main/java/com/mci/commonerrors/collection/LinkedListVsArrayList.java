package com.mci.commonerrors.collection;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedListVsArrayList {

    public static void main(String[] args) {
        int elementCount = 100000;
        int loopCount = 100000;
        // StopWatch stopWatch = new StopWatch();
        Instant start = Instant.now();

        // LinkedList get vs ArrayList get
        linkedListGet(elementCount, loopCount);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("LinkedList get(): " + timeElapsed);

        start = Instant.now();
        arrayListGet(elementCount, loopCount);
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("ArrayList get(): " + timeElapsed);

        // LinkedList add vs ArrayList add
        start = Instant.now();
        linkedListAdd(elementCount, loopCount);
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("LinkedList add(): " + timeElapsed);

        start = Instant.now();
        arrayListAdd(elementCount, loopCount);
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("ArrayList add(): " + timeElapsed);

    }

    private static void linkedListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

    private static void arrayListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

    private static void linkedListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount), 1));
    }

    private static void arrayListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount), 1));
    }
}
