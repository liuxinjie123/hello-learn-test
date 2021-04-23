package com.springboot.hello.test.str;

import io.micrometer.core.instrument.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringTest {
     /**
      * @Title: main
      * @Description:
      * @param args
      * @author
      * @date 2016年2月17日
      * 1、去掉字符串中所有的标签，获取纯文本内容
      * 2、获取html节点中img的src路径
      */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb","cc");
        if (list.contains("aa")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}