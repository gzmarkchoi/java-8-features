package com.mci.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Producer Consumer example using Lock
 */
public class ProducerAndConsumerLockDemo {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        ProducerLock producerLock = new ProducerLock(clerk);
        ConsumerLock consumerLock = new ConsumerLock(clerk);

        new Thread(producerLock, "Producer A").start();
        new Thread(consumerLock, "Consumer A").start();

        new Thread(producerLock, "Producer B").start();
        new Thread(consumerLock, "Consumer B").start();
    }
}

class ClerkLock {
    private int product = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void buy() {
        lock.lock();

        while (product >= 10) {

            try {
                System.out.println("stock full");

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + ++product);
        condition.signalAll();
    }

    public void sale() {
        lock.lock();

        try {
            while (product <= 0) {
                System.out.println("out of stock");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class ProducerLock implements Runnable {
    private Clerk clerk;

    public ProducerLock(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.buy();
        }
    }
}

class ConsumerLock implements Runnable {
    private Clerk clerk;

    public ConsumerLock(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}