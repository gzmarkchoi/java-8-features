package com.mci.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Compared to Runnable implementation, Callable could return a value, it throws an exception too.
 * <p>
 * FutureTask is used to get the result
 */
public class CallableDemo {
    public static void main(String[] args) {
        CallableThread td = new CallableThread();

        FutureTask<Integer> result = new FutureTask<>(td);
        new Thread(result).start();

        try {
            Integer sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        int sum = 0;

        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}

//class ThreadDemo implements Runnable{
//
//    @Override
//    public void run() {
//
//    }
//}