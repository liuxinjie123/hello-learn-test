package com.springboot.hello.test;

import com.springboot.hello.test.entity.ProjectFile;

public class TestObject {
    public static void main(String[] args) {
        ProjectFile file = new ProjectFile();
        file.setFileName(" test");
        System.out.println(file.toString());
    }
}