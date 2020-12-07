package com.mci.juc;

public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(producer, "Producer A").start();
        new Thread(consumer, "Consumer A").start();

        new Thread(producer, "Producer B").start();
        new Thread(consumer, "Consumer B").start();
    }
}

class Clerk {
    private int product = 0;

    public synchronized void buy() {
        while (product >= 10) {
            System.out.println("stock full");

            try {
                this.wait(); // must be used in a loop !!
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + ++product);
        this.notifyAll();
    }

    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("out of stock");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + --product);
        this.notifyAll();
    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
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

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}