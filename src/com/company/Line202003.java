package com.company;

public class Line202003 {
    public int[] solution(int n) {
        return helper(0,n);
    }
    //cnt 실행횟수,
    int[] helper(int cnt,int n){
        if(n/10 < 1) return new int[]{cnt,n};
        int tmp = 10;
        long minCnt = Long.MAX_VALUE;
        int resultN = 0;
        while(true){
            if(n/tmp < 1) {
                break;
            }
            int[] helper = helper(cnt+1,n / tmp + n % tmp);
            if(helper[0]<minCnt){
                minCnt = helper[0];
                resultN = helper[1];
            }
            tmp *= 10;
        }
        return new int[]{(int)minCnt,resultN};
    }
}
