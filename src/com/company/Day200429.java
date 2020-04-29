package com.company;

public class Day200429 {


    /**
     * @author seongwou
     * @since 2020/04/29 2:22 오후
     * <p>
     * <p>
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * <p>
     * Example:
     * <p>
     * Given linked list: 1->2->3->4->5, and n = 2.
     * <p>
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * <p>
     * Given n will always be valid.
     * <p>
     * Follow up:
     * <p>
     * Could you do this in one pass?
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;
        ListNode nth = head;
        int depth = 0;

        while (curr != null) {

            if(depth > n) {
                nth = nth.next;
            }
            curr = curr.next;
            depth++;

        }

        if(depth == n) {
            return head.next;
        }

        nth.next = nth.next.next;

        return head;

    }
}
