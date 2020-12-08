package com.mci.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A 3 Thread program, with ID A, B and C, try to display ABCABCABC... on screen
 */
public class ABCAlternateDemo {
    public static void main(String[] args) {
        AlternateThread ad = new AlternateThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    ad.loopA(i);
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    ad.loopB(i);
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    ad.loopC(i);

                    System.out.println("-------------------------------------");
                }
            }
        }, "C").start();
    }
}

class AlternateThread {
    private int number = 1; // current thread label

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop) {
        lock.lock();

        try {
            // check if number = 1
            if (number != 1) {
                condition1.await();
            }

            // print
            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);

            // awake
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop) {
        lock.lock();

        try {
            // check if number = 2
            if (number != 2) {
                condition2.await();
            }

            // print
            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);

            // awake
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop) {
        lock.lock();

        try {
            // check if number = 3
            if (number != 3) {
                condition3.await();
            }

            // print
            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);

            // awake
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}