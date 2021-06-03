package com.springboot.hello.test.jvm;

public class SynchronizedTest {
    public synchronized void do1() {
        System.out.println("Hello World");
    }

    public void do2() {
        synchronized (SynchronizedTest.class) {
            System.out.println("Hello World do2");
        }
    }
}
