package cn.edward.sparseArray;

public class SparceArray {

    public static void main(String[] args) {
        //创建11 x 11二维数组，0表示无棋子 1表示黑子 2表示白子
        int[][] cheese = new int[11][11];
        cheese[1][2] = 1;
        cheese[2][3] = 2;
        for (int[] row : cheese) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int[] row : cheese) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        int[][] spaceArray = new int[sum + 1][3];
        spaceArray[0][0] = 11;
        spaceArray[0][1] = 11;
        spaceArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (cheese[i][j] != 0) {
                    count++;
                    spaceArray[count][0] = i;
                    spaceArray[count][1] = j;
                    spaceArray[count][2] = cheese[i][j];
                }
            }
        }
        System.out.println("===================稀疏数组为===================");
        for (int[] row : spaceArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组恢复
        int[][] oriArray = new int[spaceArray[0][0]][spaceArray[0][1]];
        for (int i = 1; i < spaceArray.length; i++) {
            int row = spaceArray[i][0];
            int col = spaceArray[i][1];
            int data = spaceArray[i][2];
            oriArray[row][col] = data;
        }

        System.out.println("===================恢复数组为===================");
        for (int[] row : oriArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
