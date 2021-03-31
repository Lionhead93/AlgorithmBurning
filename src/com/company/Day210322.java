package com.company;

public class Day210322 {

    /**
     * Given the head of a singly linked list, return true if it is a palindrome.
     * <p>
     * Example 1:
     * Input: head = [1,2,2,1]
     * Output: true
     * <p>
     * Example 2:
     * Input: head = [1,2]
     * Output: false
     * <p>
     * Constraints:
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     * <p>
     * Follow up: Could you do it in O(n) time and O(1) space?
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode parent = null;
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = parent;
            parent = current;
        }
        return parent;
    }
}
