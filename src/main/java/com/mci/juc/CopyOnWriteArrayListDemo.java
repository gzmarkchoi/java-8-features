package com.mci.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Attention:
 * - low efficiency on add operations, because it copy the arraylist on each add operation
 * - better use case: concurrent loop operations
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        HelloThread ht = new HelloThread();

        for (int i = 0; i < 10; i++) {
            new Thread(ht).start();
        }
    }
}

class HelloThread implements Runnable {

    // ConcurrentModificationException
//    private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            list.add("AAA");
        }
    }
}