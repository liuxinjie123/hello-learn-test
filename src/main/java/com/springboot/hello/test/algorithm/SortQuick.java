package com.springboot.hello.test.algorithm;

/**
 * 它的基本思想是：
 *
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 */
public class SortQuick {
    public static void main(String[] args) {
        int arr[] = new int[]{3,1,6,7,999,122366,3656,39,33,1656,5,126,77,8,9,363,57765,23,12321,9};
        for (int i=0; i<arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("\n");

        sort(arr, 0, arr.length-1);

        for (int i=0; i<arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("\n");
    }

    static void sort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && arr[i] < pivot) {
                i++;
            }
            while ((i < j) && arr[j] > pivot) {
                j--;
            }
            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (i-1 > start) {
                sort(arr, 0, i-1);
            }
            if (j+1 < end) {
                sort(arr, j+1, end);
            }
        }
    }

}
