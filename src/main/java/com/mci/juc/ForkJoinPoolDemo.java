package com.mci.juc;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 100000000L);

        Long sum = pool.invoke(task);

        System.out.println(sum);

    }

    @Test
    public void testForLoop() {
        Instant start = Instant.now();

        long sum = 0L;
        for (long i = 0L; i < 10000000000L; i++) {
            sum += i;
        }

        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("Duration: " + Duration.between(start, end).toMillis()); // 3793
    }

    @Test
    public void testJava8() {
        Instant start = Instant.now();

        Long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .reduce(0L, Long::sum);

        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("Duration: " + Duration.between(start, end).toMillis()); //1933
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = -34820384023984L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000L;

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0L;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.join();

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
