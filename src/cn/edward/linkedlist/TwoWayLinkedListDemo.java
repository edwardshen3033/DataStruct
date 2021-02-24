package cn.edward.linkedlist;

public class TwoWayLinkedListDemo {
    public static void main(String[] args) {
        TwoWayLinkedList linkedList = new TwoWayLinkedList();
        Node edward = new Node("edward", 1);
        Node sss = new Node("sss", 4);
        Node zwd = new Node("zwd", 2);
        Node lll = new Node("lll", 4);
        linkedList.addByOrder(edward);
        linkedList.addByOrder(sss);
        linkedList.addByOrder(zwd);
        linkedList.addByOrder(lll);
        linkedList.list();
//        linkedList.delete(lll);
//        linkedList.delete(edward);
//        linkedList.list();
    }
}

class TwoWayLinkedList {

    Node head = new Node();

    public void add(Node node) {

        Node temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        temp.next = node;
        node.pre = temp;
    }

    public void update(Node node) {
        Node temp = head.next;

        while (true) {
            if (node.val == temp.val) {
                break;
            } else {
                temp = temp.next;
            }
            temp.test = node.test;
        }
    }

    public void delete(Node node) {
        if (node.pre == null) {
            node.next.pre = null;
            return;
        }

        if (node.next == null) {
            node.pre.next = null;
            return;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void list() {
        Node temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.val > node.val) {
                break;
            } else if (temp.next.val == node.val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("要添加的值已经存在");
        }else {
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
        }
    }
}

class Node {
    String test;
    int val;
    Node next;
    Node pre;

    public Node() {
    }

    public Node(String test, int val) {
        this.test = test;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "test='" + test + '\'' +
                ", val=" + val +
                '}';
    }
}
