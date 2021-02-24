package cn.edward.queue;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.add(3);
        System.out.println(queue.getFront());
        System.out.println(queue.getValue());
    }
}

class Queue {
    private int maxSize;
    int front;
    int rear;
    int[] queue;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;    //指向队列头
        this.rear = -1;     //指向队列尾
        this.queue = new int[maxSize];
    }

    public void add(int value) {
        if (!isFull()) {
            rear++;
            queue[rear] = value;
        } else {
            System.out.println("队列已满");
        }
    }

    public int getValue() {
        if (!isEmpty()) {
            front++;
            return queue[front];
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return queue[front + 1];
        }
    }
}
