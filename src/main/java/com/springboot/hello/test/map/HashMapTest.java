package com.springboot.hello.test.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        System.out.println(getMap());
    }

    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("KEY", "INIT");
        try {
            map.put("KEY", "TRY");
            return map;
        } catch (Exception e) {
            map.put("KEY", "CATCH");
        } finally {
            map.put("KEY", "FINALLY");// 修改y成功
            map.put("KEY", "FINALLY1");// 修改y成功
            map = new HashMap<>();
            System.out.println("map是：" + map);
        }
        System.out.println("---- 走不到此处 --------");//  ①
        return map;
    }
}
