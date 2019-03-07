package linkedlist;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    private static ListNode Merge_(ListNode list1, ListNode list2) {
        ListNode head;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            head = list1;
            head.next = Merge_(list1.next, list2);
        } else {
            head = list2;
            head.next = Merge_(list1, list2.next);
        }
        return head;
    }

    private static class ListNode {
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
        ListNode a6 = new ListNode(2);
        ListNode a7 = new ListNode(3);
        ListNode a8 = new ListNode(3);
        ListNode a9 = new ListNode(5);
        ListNode a10 = new ListNode(6);
        a6.next = a7;
        a7.next = a8;
        a8.next = a9;
        a9.next = a10;
        ListNode li = Merge_(a1, a6);
        while (li != null) {
            System.out.println(li.val);
            li = li.next;
        }
    }
}
