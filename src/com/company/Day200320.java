package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Day200320 {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    public static class KthLargest {

        PriorityQueue<Integer> queue;
        int counter;

        public KthLargest(int k, int[] nums) {
            this.counter = k;
            queue = new PriorityQueue(k);
            for(int a: nums)
                add(a);
        }

        public int add(int val) {

            queue.offer(val);

            if(queue.size() > this.counter)
                queue.poll();

            return queue.peek();
        }

        public int myAtoi(String str) {



            int result = 0;
            return result;
        }

    }

    public static void main(String[] args) {
    }

}
