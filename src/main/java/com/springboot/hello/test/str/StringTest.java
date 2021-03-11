package com.springboot.hello.test.str;

import io.micrometer.core.instrument.util.StringUtils;

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
        String error = "1234567890";
        error = error.substring(0, error.length()-1);
        System.out.println(error);
    }

}