package com.mci.juc;

/**
 * Simulate CAS algo
 */
public class CompareAndSwapDemo {
    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = cas.get();
                    boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSwap {
    private int value;

    // get memory value
    public synchronized int get() {
        return value;
    }

    // compare
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    // set
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
