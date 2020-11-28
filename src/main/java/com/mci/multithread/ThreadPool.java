package com.mci.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor serviceThreadPool = (ThreadPoolExecutor) executorService;

        // configurations
//        serviceThreadPool.set

        // for Runnable
        serviceThreadPool.execute(new NumberThreadEven());
        serviceThreadPool.execute(new NumberThreadOdd());

        serviceThreadPool.shutdown();
        // for Callable
//        service.submit(Callable callable);
    }
}

class NumberThreadEven implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThreadOdd implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}