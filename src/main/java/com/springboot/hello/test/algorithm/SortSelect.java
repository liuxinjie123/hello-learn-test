package com.springboot.hello.test.algorithm;

/**
 * 选择排序（Selection sort）是一种简单直观的排序算法。
 *
 * 它的工作原理是：
 *
 * 第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 *
 * 以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
 */
public class SortSelect {
    public static void main(String[] args) {
        int arr[] = new int[]{3,1,6,7,9,122344,4656,39,33,4656,5,126,77,8,9,343,57765,23,12321};
        for (int i=0; i<arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("\n");

        sort(arr);

        for (int i=0; i<arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("\n");
    }


    static void sort (int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}