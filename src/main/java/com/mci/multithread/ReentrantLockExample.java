package com.mci.multithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Using ReentrantLock(From JDK 5) for thread save
 * <p>
 * The differences between ReentrantLock and Synchronized?
 * - Synchronized : auto release thread after execution;
 * - ReentrantLock, manually start(lock()) and release(unlock()) thread
 */
public class ReentrantLockExample {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("Window 1");
        t2.setName("Window 2");
        t3.setName("Window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " selling ticket, ticket: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}