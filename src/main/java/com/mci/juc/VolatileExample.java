package com.mci.juc;

/**
 * Volatile example
 */
public class VolatileExample {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while (true) {
            // low efficiency
//            synchronized (td) {
//                if (td.isFlag()) {
//                    System.out.println("-----------------------");
//                    break;
//                }
//
//            }
            if (td.isFlag()) {
                System.out.println("-----------------------");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {
    // better efficiency than synchronized block
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("Flag is " + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}