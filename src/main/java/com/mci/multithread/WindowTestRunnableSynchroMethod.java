package com.mci.multithread;

/**
 * Preferred method for multi thread, especially where there's share data among threads
 *
 * Synchronized method added.
 */
public class WindowTestRunnableSynchroMethod {
    public static void main(String[] args) {
        WindowRunnableSynchroMethod window = new WindowRunnableSynchroMethod();

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

class WindowRunnableSynchroMethod implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();

        }
    }

    private synchronized void show() { // synchronized monitor: this
        if (ticket > 0) {
            try {
                Thread.sleep(100); // duplicate tickets or ticket -1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":selling ticket, ticket: " + ticket);
            ticket--;
        }
    }
}

