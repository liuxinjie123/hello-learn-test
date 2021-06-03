package com.springboot.hello.test.jvm;

import java.io.Serializable;

public class JvmTest1 {
    public static void main(String[] args) {
        Long s = System.currentTimeMillis();
        for (int i=0; i<100000000; i++) {
            alloc();
        }
        Long e = System.currentTimeMillis();

        System.out.println(" cost: " + (e - s) + " ms");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static void alloc() {
        User user = new User();
    }

    static class User implements Serializable {
        private Long id;
        private String name;
        private String phone;

    }
}
