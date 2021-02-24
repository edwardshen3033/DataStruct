package cn.edward.search;

public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        insertValueSearch(arr, 0, arr.length - 1, 101);
    }

    private static void insertValueSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal > arr[arr.length - 1] || findVal < arr[0]) {
            System.out.println("未找到");
            return;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        if (arr[mid] < findVal) {
            insertValueSearch(arr, mid + 1, right, findVal);
        } else if (arr[mid] > findVal) {
            insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            System.out.println("找到啦");
        }

    }
}
