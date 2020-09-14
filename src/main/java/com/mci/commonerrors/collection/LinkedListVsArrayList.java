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

    /*
        - 过于迷信教科书的大 O 时间复杂度
     */
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

        /*
            - 翻看 LinkedList 源码发现，插入操作的时间复杂度是 O(1) 的前提是，你已经有了那个要插入节点的指针。
              但，在实现的时候，我们需要先通过循环获取到那个节点的 Node，然后再执行插入操作。
            - 对于插入操作，LinkedList 的时间复杂度其实也是 O(n)。
         */
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
