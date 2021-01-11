package com.springboot.hello.test.algorithm;

import java.util.Arrays;
import java.util.List;

public class MiddleSearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        midSearch(list, 1);
        System.out.println("---------------");
        midSearch(list, 10);
        System.out.println("---------------");
        midSearch(list, 5);
        System.out.println("---------------");
        midSearch(list, 6);
    }

    static int midSearch(List<Integer> list, int key) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (1 == compare(list.get(middle), key)) {
                return middle;
            }
            if (0 == compare(list.get(middle), key)) {
                low = middle + 1;
            } else if (2 == compare(list.get(middle), key)) {
                high = middle - 1;
            }
        }
        return  -1;
    }

    /**
     * 0 <
     * 1 =
     * 2 >
     */
    static int compare(int num1, int num2) {
        System.out.println(num1 + " compare to " + num2);
        return num1 == num2 ? 1 : num1 < num2 ? 0 : 2;
    }
}
