package com.springboot.hello.util;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtil {

    public static String toJSON(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, String> result = new HashMap<>();
        String name = "";
        try {
            for (Field field : fields) {
                name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method m = clazz.getMethod("get" + name);
                // 调用getter方法获取属性值
                String value = String.valueOf(m.invoke(object));
                result.put(name, value);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    public static String toString(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String result = "";
        String name = "";
        try {
            for (Field field : fields) {
                name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method m = clazz.getMethod("get" + name);
                // 调用getter方法获取属性值
                String value = (String) m.invoke(object);
                result += field.getName() + " --- " + value + "\n";
                if (field.getType() == String.class) {
                    result += field.getName() + " --- " + value + "\n";
                } else if (field.getType() == int.class || field.getType() == Integer.class) {
                    result += field.getName() + " --- " + field.getInt(field.getName()) + "\n";
                } else if (field.getType() == long.class || field.getType() == Long.class) {
                    result += field.getName() + " --- " + field.getLong(field.getName()) + "\n";
                } else if (field.getType() == double.class || field.getType() == Double.class) {
                    result += field.getName() + " --- " + field.getDouble(field.getName()) + "\n";
                } else if (field.getType() == BigDecimal.class) {
                    result += field.getName() + " --- " + field.getDouble(field.getName()) + "\n";
                } else if (field.getType() == char.class || field.getType() == Character.class) {
                    result += field.getName() + " --- " + field.getChar(field.getName()) + "\n";
                } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                    result += field.getName() + " --- " + field.getBoolean(field.getName()) + "\n";
                } else if (field.getType() == short.class || field.getType() == Short.class) {
                    result += field.getName() + " --- " + field.getShort(field.getName()) + "\n";
                } else if (field.getType() == float.class || field.getType() == Float.class) {
                    result += field.getName() + " --- " + field.getFloat(field.getName()) + "\n";
                } else {
                    result += field.getName() + " --- " + field.get(field.getName()) + "\n";
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
