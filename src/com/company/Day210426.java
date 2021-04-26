package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Day210426 {

    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }
        list.sort(Integer::compareTo);

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

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
