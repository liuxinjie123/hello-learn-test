package com.springboot.hello.test.text;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Stack<Character>> res = new Stack<>();
        String str = "abc";
        String str2 = "def";
        List<String> list = Arrays.asList(str, str2);
        for (String name : list) {
            Stack<Character> stack = new Stack<>();
            for (char ch : name.toCharArray()) {
                stack.add(ch);
            }
            res.add(stack);
        }

        System.out.println("\n");

        while (!res.isEmpty()){
            Stack<Character> stack = res.pop();
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
        System.out.println("\n\n");
    }
}
