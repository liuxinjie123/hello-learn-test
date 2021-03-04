package com.springboot.hello.test.algorithm;

/**
 * 冒泡排序（Bubble Sort），是一种计算机科学领域的较简单的排序算法。
 *
 * 它重复地走访过要排序的元素列，依次比较两个相邻的元素，
 * 如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来。
 *
 * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端（升序或降序排列），就如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”。
 */
public class SortBubble {
    public static void main(String[] args) {
        int arr[] = new int[]{3,1,6,7,999,122366,3656,39,33,1656,5,126,77,8,9,363,57765,23,12321,169};
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

    private static void sort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
