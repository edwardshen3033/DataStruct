package cn.edward.linkedlist;

// 约瑟夫问题
public class CircleSingleListDemo {
    public static void main(String[] args) {
        CircleSingleList list = new CircleSingleList();
        list.addNode(5);
        list.list();
    }
}

class CircleSingleList {

    CircleNode head = null;

    public void addNode(int nums) {
        if (nums < 1) {
            System.out.println("num值不正确");
            return;
        }

        CircleNode current = null;

        for (int i = 1; i < nums; i++) {
            //根据编号创建节点
            CircleNode circleNode = new CircleNode(i);
            //如果是第一个
            if (i == 1) {
                head = circleNode;
                head.next = head;
            } else {
                current.next = circleNode;
                circleNode.next = head;
            }
            current = circleNode;
        }
    }

    public void count(int start, int count, int nums) {

        //校验
        if (head == null || start < 1 || start > nums) {
            return;
        }
        //创建辅助指针
        CircleNode temp = head;
        while (true) {
            if (temp.next == head) {
                break;
            }
            temp = temp.next;
        }

        //   报数前 先让first和temp都移动到k的位置
        CircleNode result = null;
        for (int i = 0; i < start - 1; i++) {
            head = head.next;
            temp = temp.next;
        }
        //当报数时 让first和temp 同时移动m-1次，然后出圈
        //直到圈中只有一个节点
        while (true) {
            if (temp == head) {
                break;
            }
            //让first和temp同时移动count-1次
            for (int j = 0; j < count - 1; j++) {
                temp = temp.next;
                head = head.next;
            }

            System.out.println(head.next);
            //这时将first指向的
            head = head.next;
            temp.next = head;
        }


    }

    public void list() {
        if (head == null) {
            return;
        }
        CircleNode current = head;
        while (true) {
            System.out.println(current);
            if (current.next == head) {
                break;
            } else {
                current = current.next;
            }
        }
    }

}

class CircleNode {
    String name;
    int val;
    CircleNode next;

    public CircleNode(int val) {
        this.val = val;
    }

    public CircleNode(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public CircleNode() {
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "test='" + name + '\'' +
                ", val=" + val +
                '}';
    }
}
