package com.mci.juc;

import java.util.Random;
import java.util.concurrent.*;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Future<Integer> result = scheduledExecutorService.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + ": " + num);

                    return num;
                }
            }, 1, TimeUnit.SECONDS);

            System.out.println(result.get());
        }

        scheduledExecutorService.shutdown();
    }
}
