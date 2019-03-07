package linkedlist;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class FindKthToTail {
    private static ListNode FindKthToTail_(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 1;
        ListNode old = head;
//        for (int i = 1; i < k; i++) {
//            if (old.next == null) {
//                break;
//            }
//            old = old.next;
//        }
//        while (old.next != null) {
//            old = old.next;
//            head = head.next;
//        }
//        return head;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        if (k > count) {
            return null;
        }
        for (int i = 1; i <= (count - k); i++) {
            old = old.next;
        }
        return old;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        System.out.println(FindKthToTail_(a1, 4).val);
    }
}