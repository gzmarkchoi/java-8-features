package com.mci.multithread;

/**
 * Another way to create a Thread using Runnable
 * <p>
 * 1. create a Runnable interface class
 * 2. override run() in the class
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread);
        t1.start();

        Thread t2 = new Thread(myThread);
        t2.start();
    }

}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

}
