package cn.edward.tree;

//顺序存储二叉树
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        System.out.println("前序遍历");
        arrayBinaryTree.preOrder();
        System.out.println("中序遍历");
        arrayBinaryTree.infixOrder();
        System.out.println("后序遍历");
        arrayBinaryTree.postOrder();
    }
}


class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }

    public void infixOrder(){
        infixOrder(0);
    }

    public void postOrder(){
        postOrder(0);
    }

    //编写一个方法 完成顺序存储二叉树的前序遍历

    /**
     * index 数组下标
     */
    private void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前元素
        System.out.println(arr[index]);

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }

        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }

    }

    private void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }

        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }

        //输出当前元素
        System.out.println(arr[index]);
    }

    private void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }

    }
}