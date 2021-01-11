package com.springboot.hello.test.algorithm;

public class SortQuick {
    public static void main(String[] args) {
        int arr[] = new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
        int len = arr.length-1;
        arr = qsort(arr,0,len);
        for (int i:arr) {
            System.out.print(i+"\t");
        }
    }

    static int[] qsort(int[] arr, int start, int end) {

        return arr;
    }

}
