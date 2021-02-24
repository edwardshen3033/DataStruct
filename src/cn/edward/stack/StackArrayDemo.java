package cn.edward.stack;

public class StackArrayDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(7);
        arrayStack.push(5);
        arrayStack.push(8);
        arrayStack.push(969);
        arrayStack.push(4);
        arrayStack.push(45);
        arrayStack.push(45);
        arrayStack.list();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}

class ArrayStack {
    private int stackMaxSize; //栈最大容量
    private int[] stack;//栈
    private int top;//初始位置为-1

    public ArrayStack(int stackMaxSize) {
        this.top = -1;
        this.stackMaxSize = stackMaxSize;
        stack = new int[stackMaxSize];
    }

    public boolean isFull() {
        return top == stackMaxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满 无法入栈");
            return;
        }

        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无元素出栈");
        }

        int value = stack[top];
        top--;
        return value;
    }

    //遍历时需要从栈顶遍历
    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}

