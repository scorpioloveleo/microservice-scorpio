package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyCircularQueue {

    private Integer[] data;
    private int head;
    private int tail;
    private int limit;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new Integer[k];
        head = -1;
        tail = 0;
        limit = k;


    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if(isFull()){
            return false;
        }

        //第一添加
        if(isEmpty()){
            head = 0;
        }

        tail+=1;
        if(tail == limit){
            tail = 0;
        }

        data[head] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        data[head] = null;
        head ++ ;
        if(head == limit){
            head =0;
        }

        if(head == limit){
            //最后一个参数，重置指针
            head =-1;
            tail=0;
        }

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        int index = tail - 1;
        if(index<0){
            index = limit;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(head == tail){
            return true;
        }
        return false;
    }
}

class Main{
    /*public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

        System.out.println(circularQueue.enQueue(1));// 返回 true
        System.out.println(circularQueue.enQueue(2));// 返回 true
        System.out.println(circularQueue.enQueue(3));// 返回 true
        System.out.println(circularQueue.enQueue(4));// 返回 false，队列已满


        System.out.println(circularQueue.Rear());  // 返回 3
        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true

        System.out.println(circularQueue.enQueue(4));  // 返回 true

        System.out.println(circularQueue.Rear());  // 返回 4

    }*/

    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
