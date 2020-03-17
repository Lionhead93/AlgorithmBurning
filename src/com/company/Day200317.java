package com.
        company;

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

    public boolean checkRecord(String s) {

        int lateCount = 0;
        int absentCount = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'L') {
                if(++lateCount == 3) return false;
            } else if(c == 'A') {
                lateCount = 0;
                if(++absentCount == 2) return false;
            } else {
                lateCount = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }

}
