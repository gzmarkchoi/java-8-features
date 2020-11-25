package com.mci.multithread;

/**
 * A ticket selling system using 3 windows, 100 tickets available using Thread class extension
 */
public class WindowTestThread {
    public static void main(String[] args) {
        WindowThread t1 = new WindowThread();
        WindowThread t2 = new WindowThread();
        WindowThread t3 = new WindowThread();

        t1.setName("Window 1");
        t2.setName("Window 2");
        t3.setName("Window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowThread extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (WindowThread.class) { // reflexion, WindowThread is loaded once
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":selling ticket, ticket: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }


        }
    }
}
