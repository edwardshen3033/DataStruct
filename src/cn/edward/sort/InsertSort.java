package cn.edward.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr);
    }

    private static void insertSort(int[] arr) {
//        //第一轮 => {34,101,119,1}
//        //定义待插入的数
//        int insertVal = arr[1];
//        //定义待插入数组索引(),arr[1]要和arr[0]比较
//        int insertIndex = 1 - 1;
//
//        //给insertValue找到一个插入的位置
//        //说明：
//        //1.insertIndex >=0保证不越界
//        //2.insertVal < arr[insertIndex] 说明还未找到要插入的位置
//        //3.就需要将insertIndex向后移动
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        //当循环退出时说明插入的位置找到 insertIndex + 1;
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第一轮后" + Arrays.toString(arr));
//
//        //第二轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1;
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第二轮后" + Arrays.toString(arr));

        for (int i = 1 ; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + (i + 1) + "轮后" + Arrays.toString(arr));
        }
    }

}
