package com.springboot.hello.test.algorithm;

public class SearchMiddle {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[]{1, 100, 3, 99, 8, 9, 666};

        System.out.println();
        for (int i=0; i<arr2.length; i++) {
            int location = search(arr, arr2[i]);
            if (-1 == location) {
                System.out.println(" --- 查找失败，数组中不存在元素 " + arr2[i]);
            } else {
                System.out.println(" --- 查找成功，" + arr2[i] + " 在数组中下标为： " + location + " 。");
            }
        }
        System.out.println();
    }

    private static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (1 == compare(arr[middle], key)) {
                return middle;
            } else if (0 == compare(arr[middle], key)) {
                low = middle + 1;
            } else if (2 == compare(arr[middle], key)) {
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
