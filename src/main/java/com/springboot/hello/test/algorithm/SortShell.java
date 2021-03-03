package com.springboot.hello.test.algorithm;

/**
 * 希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
 * 是直接插入排序算法的一种更高效的改进版本。
 *
 * 希尔排序是非稳定排序算法。该方法因 D.L.Shell 于 1959 年提出而得名。
 *
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止。
 */
public class SortShell {
    public static void main(String[] args) {
        int arr[] = new int[]{3,1,6,7,999,122366,3656,39,33,1656,5,126,77,8,9,363,57765,23,12321,9};
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
}
