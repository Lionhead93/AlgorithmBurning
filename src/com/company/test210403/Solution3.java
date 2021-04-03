package com.company.test210403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];

        int lastStation = 2;
        int max = 0;

        while(lastStation < n+1) {
            boolean[] visit = new boolean[n];
            visit[0] = true;
            int dp = helper(passenger, train, visit, 1, passenger[0], lastStation);

            if(dp>=max) {
                answer[0] = lastStation;
                answer[1] = dp;
                max = dp;
            }
            lastStation++;
        }

        return answer;
    }

    // spot:현재위치, cnt: 승객합, 종착 last
    public int helper(int[] passenger, int[][] train, boolean[] visit, int spot, int cnt, int lastStation) {

        if(spot == lastStation) {
            return cnt;
        }

        visit[spot-1] = true;
        boolean hasNext = false;

        int max = 0;
        for(int[] con: train) {
            if(con[0]==spot || con[1]==spot) {
                int next = con[0]==spot ? con[1] : con[0];
                if(!visit[next-1]){
                    hasNext = true;
                    visit[next-1] = true;
                    int dp = helper(passenger, train, visit, next, cnt + passenger[next-1], lastStation);
                    max = Math.max(max, dp);
                }
            }
        }
        if(!hasNext) {
            return 0;
        }
        return max;
    }
    
}
