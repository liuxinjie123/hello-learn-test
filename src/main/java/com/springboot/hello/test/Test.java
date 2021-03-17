package com.springboot.hello.test;

import java.text.ParseException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Integer isQuanYu = null;
        if (null == isQuanYu || 1 != isQuanYu) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
