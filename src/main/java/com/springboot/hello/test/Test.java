package com.springboot.hello.test;

import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        String url = "http://sit2.haowu.com/tupi1an/uploads/2020_6/1592204582510.txt";
        url = url.substring(url.indexOf("/tupian/") + 7);
        System.out.println(url);
    }
}
