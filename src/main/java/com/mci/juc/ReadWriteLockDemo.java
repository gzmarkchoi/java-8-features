package com.mci.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLockThread rw = new ReadWriteLockThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.write((int) (Math.random() * 101));
            }
        }, "Write").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.read();
                }
            }, "Read").start();
        }
    }
}

class ReadWriteLockThread {
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + ": " + number);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int number) {
        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        } finally {
            lock.writeLock().unlock();
        }
    }
}