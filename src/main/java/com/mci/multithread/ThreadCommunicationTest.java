package com.mci.multithread;

/**
 * Thread communication example using wait() and notify()
 *
 * 1. wait(), notify() and notifyAll() must be used under synchronized block or synchronized method
 * 2. wait(), notify() and notifyAll() must have the same synchronized monitor as the synchronized block
 *      or the synchronized method(obj in this example), otherwise IllegalMonitorStateException
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}

class Number implements Runnable {
    private int number = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                obj.notify();
                if (number < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
