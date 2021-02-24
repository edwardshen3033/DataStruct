package cn.edward.sort;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {7, 63, 21, 17, 233, 514, 16};
        radixSort(arr);
    }

    private static void radixSort(int[] arr) {

        //第一轮排序（针对每个元素的个位进行排序）
        //定义一个二维数组表示十个桶 每个桶表示一个一维数组
        //说明：
        //1.为了防止在放置时候数据溢出，每个一维数组大小定义为arr.length
        //2.基数排序是用空间换时间的算法
        int[][] buckets = new int[10][arr.length];

        //为了记录每个桶中存放了多少数据，定义一个一维数组 记录各个桶放入数据的个数
        //bucketElement[0]记录的是第0个桶放入的数据个数
        int[] bucketElementCounts = new int[10];

        //第一轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位
            int digitElement = arr[j] % 10;
            //放入桶中
            buckets[digitElement][bucketElementCounts[digitElement]] = arr[j];
            bucketElementCounts[digitElement]++;
        }
    }
}
