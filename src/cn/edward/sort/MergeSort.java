package cn.edward.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //分
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    //合并

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //初始化i 左边有序序列的初始索引
        int j = mid + 1; //右边有序序列的初始索引
        int tempIndex = 0; //指向temp数组的索引

        //（1）
        //先把左右两边（有序）的数据按规则填充到temp数组
        //直到左右两边有序序列有一边处理完为止
        while (i <= mid && j <= right) {
            //如果左边有序序列的元素小于等于右边有序序列的元素，将左边序列的元素拷贝到temp中
            if (arr[i] <= arr[j]) {
                temp[tempIndex] = arr[i];
                i++;
            } else {
                temp[tempIndex] = arr[j];
                j++;
            }
            tempIndex++;
        }

        //(2)
        //把剩余数据的一边的数据依次全部填充到temp

        //说明左边有剩余
        while (i <= mid) {
            temp[tempIndex] = arr[i];
            i++;
            tempIndex++;
        }

        while (j <= right) {
            temp[tempIndex] = arr[j];
            j++;
            tempIndex++;
        }

        //(3)
        //将temp填充到原数组中
        //注意并不是每次都拷贝所有
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right){  //第一次合并 tempLeft = 0, right = 1 , 第二次 tempLeft = 2, right = 3
            arr[tempLeft] = temp[tempIndex];
            tempLeft++;
            tempIndex++;
        }
    }
}
