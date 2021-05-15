package com.company;

public class Day210515 {

    static void minimumBribes(int[] q) {
        for(int i = 0 ; i < q.length ; i ++) {
            if(q[i]-(i+1)>2) {
                System.out.println("Too chaotic");
                return;
            }
        }
        int count = 0;
        for(int i = 0 ; i < q.length ; i ++) {
            if(i+1 != q[i]) {
                int tmpS = i+1;
                for(int j = i+1; j< q.length ; j++) {
                    if(q[j] == tmpS) {
                        int tmp = q[j-1];
                        q[j-1] = q[j];
                        q[j] = tmp;

                        count += 1;
                        i--;
                        j = q.length;
                    }
                }
            }
        }
    }

}
