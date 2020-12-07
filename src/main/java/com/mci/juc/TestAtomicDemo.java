package com.mci.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * i++ atomic issue: i++ operations: read - modify - write
 * <p>
 * int i = 10;
 * i = i++;
 * <p>
 * 1. int temp = 1;
 * 2. i = i + 1;
 * 3. i = temp;
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable {
//    private int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " + getSerialNumber());
    }

    public int getSerialNumber() {
//        return serialNumber++;
        return serialNumber.getAndIncrement();
    }
}