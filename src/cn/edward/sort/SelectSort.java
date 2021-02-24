package cn.edward.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {10, -1, 2, 6, 7};
        sort(arr);
    }

    private static void sort(int[] arr) {
//        //第一轮排序
//        int minIndex = 0;
//        int min = arr[minIndex];
//        for (int j = 0 + 1; j < arr.length; j++) {
//            if (min > arr[j]){
//                min = arr[j]; //重置最小值
//                minIndex = j;//重置minindex
//            }
//        }
//        //交换
//        arr[minIndex] = arr[0];
//        arr[0] = min;
//        System.out.println("第一轮后:" + Arrays.toString(arr));
//
//        minIndex = 1;
//        min = arr[minIndex];
//        for (int j = 2; j < arr.length; j++) {
//            if (min > arr[j]){
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//        arr[minIndex] = arr[1];
//        arr[1] = min;
//        System.out.println("第二轮后:" + Arrays.toString(arr));
//      以此类推
        //时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "次排序结果为:" + Arrays.toString(arr));
        }
    }

}
