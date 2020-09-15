package JianZhiOffer;

import java.util.Stack;

public class ReversePrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int[] ints = reversePrint(head);
    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (null != head){
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = stack.pop().val;
        }
        return ints;
    }
}
