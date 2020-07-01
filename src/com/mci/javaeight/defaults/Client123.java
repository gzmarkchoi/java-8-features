package com.mci.javaeight.defaults;

public class Client123 implements Interface1, Interface2, Interface3 {
    public void methodA() {
        System.out.println("Inside method A: " + Client123.class);
    }

    public static void main(String[] args) {
        Client123 client = new Client123();
        client.methodA(); // resolve to the child implementation
        client.methodB();
        client.methodC();
    }
}
