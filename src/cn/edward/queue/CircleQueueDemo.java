package cn.edward.queue;

public class CircleQueueDemo {
}

class CircleQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] queue;

    public CircleQueue(int maxSize) {
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }

    private boolean isEmpty() {
        return front == rear;
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void add(int value) {
        if (isEmpty()) {
            queue[rear] = value;
            rear = (rear + 1) % maxSize;
        }
    }

    public int getValue() {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        } else {

            //需要分析出front指向队列第一个元素
            //先把front 值保存到一个临时变量
            //将front后移
            int value = queue[front];
            front = (front + 1) % maxSize;
            return value;
        }
    }

    public int getEffectiveValue() {
        if (isEmpty()) {
            return 0;
        } else if (isFull()) {
            return maxSize;
        } else {
            return (rear + maxSize - front) % maxSize;
        }
    }
}
