package com.springboot.hello.test.reflect;

public class ReflectTest {
    public static void main(String[] args) {
        String name = "jack";
        Class clazz = name.getClass();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass());

        name = "java.lang.String";
        try {
            clazz = Class.forName(name);
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("uncorrect class name.");
        }

        System.out.println("\n");

        Class c1 = Boolean.TYPE;
        Class c2 = Byte.TYPE;
        Class c3 = Float.TYPE;
        Class c4 = Double.TYPE;
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
        System.out.println(c4.getName());



    }
}
