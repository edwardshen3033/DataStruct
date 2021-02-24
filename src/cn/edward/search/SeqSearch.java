package cn.edward.search;

public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {-1, 10, 23, 789, 6};
        search(arr,6);
    }

    private static int search(int[] arr,int val){
        for (int i = 0; i < arr.length; i++) {
            //线性查找就是遍历查找
            if (arr[i] == val){
                System.out.println("已经找到");
                return val;
            }
        }
        System.out.println("没找到");
        return -1;
    }
}
