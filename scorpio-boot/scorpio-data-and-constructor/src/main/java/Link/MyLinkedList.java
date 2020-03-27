package Link;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {

    private MyNode first;
    private MyNode last;
    private MyNode cur;
    private MyNode pre;
    private MyNode next;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(size == 0 || index >=size){
            return -1;
        }

        cur = first;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.i;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(first == null){
            first = new MyNode(val, null);
            last = first;
            size++;
            return;
        }

        MyNode myNode = new MyNode(val, first);
        first = myNode;
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(last == null){
            last= new MyNode(val, null);
            first = last;
            size++;
            return;
        }
        MyNode myNode = new MyNode(val, null);
        last.next = myNode;
        last = myNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index >= size ){
            return;
        }
        cur = first;
        pre = first;
        for (int i = 0; i < index; i++) {
            pre = cur;
            cur = cur.next;
        }

        if(index == 0){
            addAtHead(val);
        }else {
            MyNode myNode = new MyNode(val, cur);
            pre.next = myNode;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size ){
            return;
        }
        cur = first;
        pre = first;
        for (int i = 0; i < index; i++) {
            pre = cur;
            cur = cur.next;
        }
        next = cur.next;
        if(index==0){
            if(size >1){
                first = next;
            }else {
                first = null;
                last = null;
            }
        }else {
            pre.next = next;
        }
        size--;
    }

    /**
     * 打印
     */
    public void show(){
        String str ="";
        for (int i = 0; i < size; i++) {
            str = str + get(i)+"-->";
        }
        System.out.println(str);
    }

    private class MyNode{
        int i;
        MyNode next;

        public MyNode(int i, MyNode myNode) {
            this.i = i;
            this.next = myNode;
        }
    }

    /**
     * 反转
     */
    public void reverse(){
        if(size <=1){
            return;
        }
        cur = first.next;
        pre = first;
        next = cur.next;
        first.next = null;
        last = first;
        for (int i = 0; i < size-1; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if(i+2 != size){
                next = next.next;
            }
        }
        first = pre;
    }
}

class LinkMain{
    /*public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));//返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.show();
        System.out.println(linkedList.get(1));//返回3
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.addAtTail(6);
        linkedList.addAtTail(7);
        linkedList.show();
        linkedList.addAtIndex(1,2);
        linkedList.show();
        linkedList.deleteAtIndex(4);
        linkedList.show();

        //反转一个链表
        linkedList.reverse();
        linkedList.show();
    }*/

    public static void main(String[] args) {
        //测试
        List<Integer> list = new ArrayList<>();
        long startAdd = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long startEnd = System.currentTimeMillis();
        System.out.println("list 添加耗时: "+(startEnd - startAdd)/1000);

        long startAdd01 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long startEnd01 = System.currentTimeMillis();
        System.out.println("list 添加耗时: "+(startEnd01 - startAdd01)/1000);


    }
}