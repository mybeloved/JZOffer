package linkedlist;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode ReverseList_(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        Stack<ListNode> sta = new Stack<>();
//        while (head != null) {
//            sta.push(head);
//            head = head.next;
//        }
//        ListNode newhead = sta.pop();
//        ListNode resulthead = newhead;
//        while (!sta.empty()) {
//            newhead.next = sta.pop();
//            newhead = newhead.next;
//        }
//        newhead.next = null;
//        return resulthead;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
        ListNode li = ReverseList_(a1);
        while (li != null) {
            System.out.println(li.val);
            li = li.next;
        }
    }
}
