package cn.edward.tree;

//线索化二叉树
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {

        //测试中序线索化二叉树
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(10);
        Node node6 = new Node(14);

        //二叉树以后递归创建 现在手动创建
        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node3.setLeftNode(node6);

        //测试线索化二叉树
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(node1);
        threadBinaryTree.threadedNodes();
        System.out.println("10号节点的前驱节点 " + node5.getLeftNode());
        System.out.println("10号节点的后继节点 " + node5.getRightNode());
    }
}

class ThreadBinaryTree {

    private Node root;

    //为了实现线索化 需要创建一个指向当前节点的前驱节点的指针
    //在递归线索化时，pre总是保留前一个节点
    private Node pre = null;

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空无法遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空无法遍历");
        }
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //编写对二叉树中序线索化的方法
    //Node就是需要线索化的节点
    private void threadedNodes(Node node) {
        //如果为空 就不能线索化
        if (node == null) {
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeftNode());
        //线索化当前节点（有难度）
        //处理当前节点的前驱节点
        if (node.getLeftNode() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeftNode(pre);
            //修改当前节点左指针类型
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.getRightNode() == null) {
            //让前驱节点右指针指向当前节点
            pre.setRightNode(node);
            pre.setRightType(1);
        }

        //每处理一个节点后 让当前节点作为下一个节点的前驱节点
        pre = node;
        //线索化右子树
        threadedNodes(node.getRightNode());
    }
}


class Node {

    private int val;

    Node leftNode;

    Node rightNode;

    //leftType = 0 则表示指向左子树 leftType = 1指向前驱节点
    private int leftType;
    //rightType = 0 则表示指向子树 rightType = 1指向后继节点
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }


    //前序遍历
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //向左子树遍历
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        //递归向右子树遍历
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }

        System.out.println(this);

        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    public void postOrder() {
        if (this.leftNode != null) {
            this.leftNode.postOrder();
        }

        if (this.rightNode != null) {
            this.rightNode.postOrder();
        }
        System.out.println(this);
    }
}

