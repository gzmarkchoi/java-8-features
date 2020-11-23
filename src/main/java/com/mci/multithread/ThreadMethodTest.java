package com.mci.multithread;

/*
    start()
    run()
    currentThread()
    getName()
    setName()
    yield()
    join()
    sleep()

 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread: 1");
//        h1.setName("Thread001");

        h1.start();
        Thread.currentThread().setName("main Thread");

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i + Thread.currentThread().getPriority() + " thread priority: ");
            }

            if (i == 20) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }

//            if (i % 20 == 0) { // release CPU for other another thread
//                yield();
//            }
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}