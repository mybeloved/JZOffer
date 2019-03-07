package linkedlist;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走（因为2个链表用公共的尾部）
    public ListNode FindFirstCommonNode_(ListNode pHead1, ListNode pHead2) {
        int len1 = findListLenth(pHead1);
        int len2 = findListLenth(pHead2);
        if (len1 > len2) {
            pHead1 = walkStep(pHead1, len1 - len2);
        } else {
            pHead2 = walkStep(pHead2, len2 - len1);
        }
        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    private int findListLenth(ListNode pHead1) {
        if (pHead1 == null) {
            return 0;
        }
        int sum = 1;
        while ((pHead1 = pHead1.next) != null) {
            sum++;
        }
        return sum;
    }

    private ListNode walkStep(ListNode pHead1, int step) {
        while (step > 0) {
            pHead1 = pHead1.next;
            step--;
        }
        return pHead1;
    }
}

