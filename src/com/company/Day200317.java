package com.company;

public class Day200317 {

    public static int hammingDistance(int x, int y) {
        String strX = Integer.toBinaryString(x);
        String strY = Integer.toBinaryString(y);
        if (strX.length() > strY.length()) {
            int t = strX.length() - strY.length();
            for (int i = 0; i < t; i++) {
                strY = "0".concat(strY);
            }
        } else {
            int t = strY.length() - strX.length();
            for (int i = 0; i < t; i++) {
                strX = "0".concat(strX);
            }
        }

        int answer = 0;

        for(int i=0 ; i< strX.length(); i++) {
            if(strX.charAt(i) != strY.charAt(i)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }

}
