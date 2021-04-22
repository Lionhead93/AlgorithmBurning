package com.company;

public class Day210422 {

    static int minimumSwaps(int[] arr) {
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {

            while(arr[i] != i+1) {
                int temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1] = temp;
                cnt++;
            }

        }
        return cnt;

    }


}
