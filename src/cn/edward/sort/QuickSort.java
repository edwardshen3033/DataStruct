package cn.edward.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {7, 3, 8, 4, -1, 10, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int temp = 0;

        int key = arr[left];

        while (i < j) {
            while (j > i && arr[j] >= key) {
                j--;
            }
            while (i < j && arr[i] <= key) {
                i++;
            }

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        arr[left] = arr[i];
        arr[i] = key;


        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}