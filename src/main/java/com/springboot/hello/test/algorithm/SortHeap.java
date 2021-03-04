package com.springboot.hello.test.algorithm;

/**
 * 堆排序（英语：Heapsort）
 * 是指利用堆这种数据结构所设计的一种排序算法。
 *
 * 堆是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 在堆的数据结构中，堆中的最大值总是位于根节点（在优先队列中使用堆的话堆中的最小值位于根节点）。
 * 堆中定义以下几种操作：
 * 最大堆调整（Max Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 * 创建最大堆（Build Max Heap）：将堆中的所有数据重新排序
 * 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算。
 */
public class SortHeap {
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

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
