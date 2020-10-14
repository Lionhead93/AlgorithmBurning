package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line202002 {

    public static int[] solution(int[] ball, int[] order) {

        int[] answer = new int[ball.length];

        int length = ball.length;
        int idx = 0;
        while (idx<length){
            for(int i=0; i<order.length; i++){
                if(order[i]==ball[0]){
                    answer[idx] = ball[0];
                    order[i] = -1;
                    int[] tmp = new int[ball.length-1];
                    for(int j=0; j<tmp.length; j++){
                        tmp[j] = ball[j+1];
                    }
                    ball = tmp;
                    break;
                }
                if(order[i]==ball[ball.length-1]){
                    order[i] = -1;
                    answer[idx] = ball[ball.length-1];
                    int[] tmp = new int[ball.length-1];
                    for(int j=0; j<tmp.length; j++){
                        tmp[j] = ball[j];
                    }
                    ball = tmp;
                    break;
                }
            }
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5, 6},new int[]{6, 2, 5, 1, 4, 3});
    }
}
