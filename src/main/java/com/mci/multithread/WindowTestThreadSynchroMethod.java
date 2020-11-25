package com.mci.multithread;

/**
 * A ticket selling system using 3 windows, 100 tickets available using Thread class extension.
 * <p>
 * Synchronized method used.
 */
public class WindowTestThreadSynchroMethod {
    public static void main(String[] args) {
        WindowThreadSynchroMethod t1 = new WindowThreadSynchroMethod();
        WindowThreadSynchroMethod t2 = new WindowThreadSynchroMethod();
        WindowThreadSynchroMethod t3 = new WindowThreadSynchroMethod();

        t1.setName("Window 1");
        t2.setName("Window 2");
        t3.setName("Window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowThreadSynchroMethod extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();

        }
    }

    // must be static
    private static synchronized void show() { //synchronized monitor: t1, t2, t3
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":selling ticket, ticket: " + ticket);
            ticket--;
        }
    }
}
