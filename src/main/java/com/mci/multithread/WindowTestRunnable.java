package com.mci.multithread;

/**
 * Preferred method for multi thread, especially where there's share data among threads
 */
public class WindowTestRunnable {
    public static void main(String[] args) {
        WindowRunnable window = new WindowRunnable();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("Window 1");
        t2.setName("Window 2");
        t3.setName("Window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowRunnable implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":selling ticket, ticket: " + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
