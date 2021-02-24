package cn.edward.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 7, 8, 123, 456, 456, 456, 456, 456, 456789};
        List<Integer> matcherList = getMatcherList(arr, 0, arr.length - 1, 456);
        System.out.println(matcherList.size());
    }

    private static void binarySearch(int[] arr, int left, int right, int findValue) {
        int low = left;
        int high = right;
        if (low > high) {
            System.out.println("未找到");
            return;
        }
        int mid = (low + high) / 2;
        int midValue = arr[mid];
        if (findValue < midValue) {
            binarySearch(arr, left, mid - 1, findValue);
        } else if (findValue > midValue) {
            binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue == midValue) {
            System.out.println("已找到");
        }
    }

    //完成课后思考题 如果数组中有多个相同的数 需要全部找到
    /*
     *在找到mid后不要立刻返回
     *向mid左边扫描将所有满足的下标加到集合中
     *向mid右边扫描将所有满足的下标加到集合中
     * 返回集合list
     * */

    private static List<Integer> getMatcherList(int[] arr, int left, int right, int findVal) {
        int low = left;
        int high = right;
        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findVal > midValue) {
            getMatcherList(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {
            getMatcherList(arr, left, mid - 1, findVal);
        } else {
            List<Integer> arrayList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                } else {
                    arrayList.add(Integer.valueOf(temp));
                    temp -= 1;
                }
            }
            arrayList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                } else {
                    arrayList.add(Integer.valueOf(temp));
                    temp += 1;
                }
            }
            return arrayList;
        }
        return null;
    }
}
