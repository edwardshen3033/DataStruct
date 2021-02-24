package cn.edward.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
    }

    //交换法
    private static void shellSort(int[] arr) {
//        //逐步推导
//        //希尔排序第一轮
//        //将10个数据分成5组
//        int gap = arr.length / 2;
//        for (int i = 5; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组2个元素） 步长5
//            for (int j = i - 5; j >= 0; j -= 5) {
//                //如果当前元素>当前元素索引+步长后的元素说明需要交换
//                if (arr[j] > arr[j + 5]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//         System.out.println("希尔排序第一轮后" + Arrays.toString(arr));
//
//        //希尔排序第二轮
//        //将10个数据分成5组
//        gap = gap / 2;
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组2个元素） 步长5
//            for (int j = i - 2; j >= 0; j -= 2) {
//                //如果当前元素>当前元素索引+步长后的元素说明需要交换
//                if (arr[j] > arr[j + 2]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println("希尔排序第二轮后" + Arrays.toString(arr));
        int gap = arr.length / 2;
        int count = 0;
        for (int i = gap; i > 0; gap = gap / 2) {
            for (int j = gap; j < arr.length; j++) {
                for (int k = j - gap; k >= 0; k -= gap) {
                    if (arr[k] > arr[k + gap]) {
                        int temp = arr[k];
                        arr[k] = arr[k + gap];
                        arr[k + gap] = temp;
                    }
                }
            }
            count++;
            System.out.println("第" + count + "次排序结果为:" + Arrays.toString(arr));
        }
    }

    //移动法
    private static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //从第gap个元素逐个对其所在的组进行直接插入
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int value = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && value < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j] = value;
            }
        }
    }
}
