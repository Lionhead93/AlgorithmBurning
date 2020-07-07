package com.company;

import javafx.scene.paint.Material;

import java.util.Arrays;

public class Day200707 {

    public static int solution(String G) {


        char[] arr = G.toCharArray();

        int[] counter = new int[3];
        for(char c : arr) {
            switch (c){
                case 'R':
                    counter[0]++;
                    break;
                case 'S':
                    counter[1]++;
                    break;
                case 'P':
                    counter[2]++;
                    break;
            }
        }

        return Math.max( (counter[0] + counter[1]*2), Math.max ((counter[1] + counter[2]*2),(counter[2] + counter[0]*2)));
    }

    public static int solution2(int[] A) {

        int answer = 0;
        int lastPoint = 0;
        int currPoint = 1;

        while(currPoint < A.length) {

            int beforeMax = A[lastPoint];
            for (int i = lastPoint+1; i<currPoint; i++) {
                beforeMax = Math.max(A[i], beforeMax);
            }
            int afterMin = A[currPoint];
            for (int j = currPoint+1; j<A.length; j++) {
                afterMin = Math.min(A[j],afterMin);
            }

            if(beforeMax < afterMin) {
                answer++;
                lastPoint = currPoint;
            }
             currPoint++;
        }

        return answer+1;
    }
    public static int solution3(int[] A) {
        return helper(A);
    }

    public static int helper(int[] A) {

        int min = 100001;
        int idx = 0;

        for(int i = 0; i<A.length; i++) {
            if( A[i] < min) {
                idx = i;
                min = A[i];
            }
        }
        if(idx == 0 || idx ==A.length-1){
            return 1;
        } else {
            int[] B =  Arrays.copyOfRange(A, 0, idx);
            int[] C =  Arrays.copyOfRange(A, idx, A.length);
            return 1+ helper(B) + helper(C);
        }
    }

    public static void main(String[] args) {

        System.out.println(solution2(new int[]{2,4,1,6,5,9,7}));
        System.out.println(solution2(new int[]{4,3,2,6,1}));
        System.out.println(solution2(new int[]{2,1,6,4,3,7}));
        System.out.println(solution2(new int[]{1,4,2,18}));

    }
}
