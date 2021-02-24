package cn.edward.sort;

import java.util.Arrays;

public class BubbleSort {

    private static int[] arr = {3, 9, -1, 10, -2};


    public static void main(String[] args) {

        //推导代码
        //第一趟排序 把最大的数放在最后
//        for (int j = 0; j < arr.length - 1; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第一趟排序后"+ Arrays.toString(arr));
//
//        //第二趟排序
//        for (int j = 0; j < arr.length - 2; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第二趟排序后"+ Arrays.toString(arr));
//
//        for (int j = 0; j < arr.length - 3; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第三趟排序后"+ Arrays.toString(arr));
//
//
//        for (int j = 0; j < arr.length - 4; j++) {
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第四趟排序后"+ Arrays.toString(arr));

        //时间复杂度O(n^2)
        int temp = 0;//用来交换
        boolean flag = false; //用来表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //在一趟排序中一次都没进行交换过
            if (!flag) {
                break;
            } else {
                //重置回
                flag = false;
            }
        }
    }
}
