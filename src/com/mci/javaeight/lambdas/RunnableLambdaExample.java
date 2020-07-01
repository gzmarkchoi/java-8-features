package com.mci.javaeight.lambdas;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        /**
         * prior Java 8
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        };

        new Thread(runnable).start();

        // Java 8 lambda
        Runnable runnableLambda = () -> System.out.println("Inside Runnable lambda");

        new Thread(runnableLambda).start();

        new Thread(() -> System.out.println("Lambda inside Thread()")).start();
    }
}
