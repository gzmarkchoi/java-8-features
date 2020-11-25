package com.mci.multithread;

/**
 * Singleton mode
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;


    public static Bank getInstance() {
        // method 1, low efficiency
//    synchronized (Bank.class) { // thread save, lock is Bank.class
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//    }

        // method 2, better efficiency
        if (instance == null) {
            synchronized (Bank.class) { // thread save, lock is Bank.class
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
