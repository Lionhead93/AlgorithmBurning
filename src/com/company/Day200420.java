package com.company;

public class Day200420 {

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return l1;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next  = l1;
                dummy = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                dummy = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null) {
            dummy.next = l2;
        }else if(l2 == null) {
            dummy.next = l1;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

    }

}
