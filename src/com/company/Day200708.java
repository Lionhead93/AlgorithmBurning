package com.company;

public class Day200708 {

    public static int solution(int N) {
        // write your code in Java SE 8
        int max = 0;
        boolean flag = false;
        int temp = 0;

        //converting number into binary and at the same time checking for max binary gap
        while (N != 0) {

            if (N%2 == 1) {
                flag = true;
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            }
            else {
                if (flag) {
                    temp++;
                }
            }

            N = N/2;
        }

        return max;
    }
    public static void main(String[] args) {
        System.out.println(solution(1041));
    }

}
