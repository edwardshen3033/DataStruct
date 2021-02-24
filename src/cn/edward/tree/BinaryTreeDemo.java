package cn.edward.tree;

public class BinaryTreeDemo {


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        //先手动创建二叉树
        root.setLeftNode(treeNode2);
        root.setRightNode(treeNode3);
        treeNode3.setLeftNode(treeNode4);
        treeNode3.setRightNode(treeNode5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}


//定义二叉树
class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
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

    public void del(TreeNode node) {
        if (this.root != null) {
            //判断root是不是要删除的节点
            if (this.root.getVal() == node.getVal()) {
                this.root = null;
            } else {
                this.root.delNode(node);
            }
        } else {
            System.out.println("空树无法删除");
        }
    }
}

class TreeNode {

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    private int val;

    TreeNode leftNode;

    TreeNode rightNode;

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


    //递归删除节点
    //如果删除的节点是叶子节点就删除该节点
    //如果删除的节点是非叶子就删除该子树

    public void delNode(TreeNode node) {

        if (this.leftNode != null && this.leftNode.val == node.val) {
            this.leftNode = null;
            return;
        }

        if (this.rightNode != null && this.rightNode.val == node.val) {
            this.rightNode = null;
            return;
        }

        //如果没有成功删除 则向左右子树递归删除
        if (this.leftNode != null) {
            this.leftNode.delNode(node);
        }
        if (this.rightNode != null) {
            this.rightNode.delNode(node);
        }
    }
}