package com.springboot.hello.test.str;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    /**
     * @Title: main
     * @Description:
     * @param args
     * @authorpublic class Test {
     *  /**
     *   * @Title: main
     *   * @Description:
     *   * @param args
     *   * @author
     *   * @date 2016年2月17日
     *   * 1、去掉字符串中所有的标签，获取纯文本内容
     *   * 2、获取html节点中img的src路径
     *   */


    public static void main(String[] args) {
        String html = "<div><p style='color:red;'>12132第一串字符</p></div><br /><div><p>这是第二窜字符</p></div><img width='199' src='_image/12/label'/><img width='199' src='_image/13/label'/><img width='199' src='_image/14/label'/>";
        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        Matcher m = p.matcher(html);
        List<String> srcs = new ArrayList<String>();
        while (m.find()) {
            srcs.add(m.group(1));
        }
        String regex = "<[^>]*>";
        String str = html.replaceAll(regex, "");
        System.out.println(str + "\n" + srcs.get(0));
    }

}