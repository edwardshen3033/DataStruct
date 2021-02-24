package cn.edward.stack;

public class StackNodeDemo {

    public static void main(String[] args) {
        NodeStack nodeStack = new NodeStack();
        nodeStack.push(new Node(72));
        nodeStack.push(new Node(85));
        nodeStack.push(new Node(7));
        nodeStack.push(new Node(629));
        System.out.println(nodeStack.pop());
        System.out.println(nodeStack.pop());
        System.out.println(nodeStack.pop());
        System.out.println(nodeStack.pop());
    }
}

class NodeStack {
    Node top = new Node(-1);

    private boolean isEmpty() {
        return top.value == -1 && top.next == null;
    }

    public void push(Node node) {
        top.next = node;
        node.pre = top;
        top = top.next;
    }

    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无元素出栈");
        }
        Node temp = top;
        top = top.pre;
        return temp;
    }
}

class Node {
    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    int value;
    Node next;
    Node pre;
}
