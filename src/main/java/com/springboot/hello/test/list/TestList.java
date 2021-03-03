package com.springboot.hello.test.list;

public class TestList {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("hello");
        str.append(",");
        String result = str.toString();
        System.out.println("result:" + result);
        if (result.length() == 0) {
            System.out.println("result:" + result);
        } else {
            result = result.substring(0, result.length() - 1) + "。";
            System.out.println("result:" + result);
        }
    }
}
