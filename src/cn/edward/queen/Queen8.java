package cn.edward.queen;

public class Queen8 {

    //8个皇后
    private static final int MAX = 8;
    //保存结果
    int [] result = new int[MAX];
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
    }

    //写一个方法将皇后摆放的位置打印出来
    public void show(){
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("");
    }
    //查看我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的冲突
    //n表示第n个皇后
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //说明
            //result[i] == result[n]表示第n个皇后 是否和前面n-1个皇后在同一列冲突
            //Math.abs(n-i) == Math.abs(result[n] -result[i])表示第n个皇后是否和前面n-1个皇后在同一个斜线
            //n = 1表示第二个皇后 假如放在第二列 result[1] = 1
            //Math.abs(1-0) == Math.abs(result[1] - result[0])
            //没有必要判断同一行
            if (result[i] == result[n] || Math.abs(n-i) == Math.abs(result[n] -result[i])){
                return false;
            }
        }
        return true;
    }

    //编写一个方法 放置第n个皇后
    //check每一次递归进入check的都有一套自己的for循环，因此会有回溯
    private void check(int n){
        if (n==MAX){ //n==8 前8个皇后已经放好
            show();
            return;
        }else {
            //依次放置 并判断是否冲突
            for (int i = 0; i < MAX; i++) {
                //先把当前这个皇后n 先放到该行第一列
                result[n] = i;
                //判断当放置第n个皇后到i时是否冲突
                if (judge(n)){ //说明不冲突，接着放第n+1个皇后
                    check(n+1);
                }else { //说明冲突，就继续执行result[n] = i;将本行的皇后后移一个位置

                }
            }
        }
    }
}

