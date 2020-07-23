package com.springboot.hello.test;

import java.text.ParseException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        String signId = "1,,3,4,7,5,2,6,";
        List<Integer> signIdList = new ArrayList<>();
        for (String sighIdStr : signId.split(",")) {
            try {
                signIdList.add(Integer.valueOf(sighIdStr));
            } catch(Exception e) {
                System.out.println(" 包含有非法字符 ");
            }
        }

        Collections.sort(signIdList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(signIdList);
        System.out.println(signIdList.get(0));

        String signSr = signIdList.toString();
        signSr = signSr.replace("[", ",");
        signSr = signSr.replace("]", ",");
        System.out.println("signStr: " + signSr);
    }
}
