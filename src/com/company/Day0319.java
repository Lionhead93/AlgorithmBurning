package com.company;

import java.util.HashSet;

public class Day0319 {

    /**
     * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
     * <p>
     * For example, the following two linked lists begin to intersect at node c1:
     * <p>
     * <p>
     * It is guaranteed that there are no cycles anywhere in the entire linked structure.
     * <p>
     * Note that the linked lists must retain their original structure after the function returns.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * Output: Intersected at '8'
     * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
     * <p>
     * Example 2:
     * <p>
     * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Intersected at '2'
     * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     * <p>
     * Example 3:
     * <p>
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: No intersection
     * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * Explanation: The two lists do not intersect, so return null.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes of listA is in the m.
     * The number of nodes of listB is in the n.
     * 0 <= m, n <= 3 * 104
     * 1 <= Node.val <= 105
     * 0 <= skipA <= m
     * 0 <= skipB <= n
     * intersectVal is 0 if listA and listB do not intersect.
     * intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.
     * <p>
     * <p>
     * Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?
     * <p>
     * https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp1 = headA, temp2 = headB;
        while (temp1 != null || temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = (temp1 == null) ? headB : temp1.next;
            temp2 = (temp2 == null) ? headA : temp2.next;
        }
        return null;
    }

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
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     * <p>
     * Follow up: Could you do it in O(n) time and O(1) space?
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
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
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    /**
     * Given the root of a Binary Search Tree and a target number k,
     * return true if there exist two elements in the BST such that their sum is equal to the given target.
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

}
