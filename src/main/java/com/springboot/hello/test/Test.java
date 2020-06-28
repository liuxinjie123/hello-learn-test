package com.springboot.hello.test;

import com.springboot.hello.dto.Order;

import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        Order order = new Order();
        if (order.getType() != 1) {
            System.out.println(" != 1");
        } else {
            System.out.println(" = 1");
        }
        System.out.println(order.getType());
    }
}
