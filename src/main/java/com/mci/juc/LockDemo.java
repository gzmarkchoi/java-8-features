package com.mci.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();

        new Thread(ticketThread, "Window 1").start();
        new Thread(ticketThread, "Window 2").start();
        new Thread(ticketThread, "Window 3").start();
    }
}

class TicketThread implements Runnable {

    private int ticket = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "tickets left " + --ticket);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}