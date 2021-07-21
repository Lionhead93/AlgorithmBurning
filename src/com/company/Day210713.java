package com.company;

public class Day210713 {

    public int[] solutiontest(int[][] v) {
        int[] answer = new int[2];

        answer[0] = v[0][0] ^ v[1][0] ^ v[2][0];
        answer[1] = v[0][1] ^ v[1][1] ^ v[2][1];

        return answer;
    }

    public int solution1(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        for (int i = 0; i < months; i++) {

            int tmp = Math.floorDiv(money, 100) * 100;

            if (tmp < threshold) {
                continue;
            }
            int ceil = maxratio - minratio;
            int additionalRatio = ( tmp - threshold ) / ranksize;
            if (additionalRatio > ceil) {
               money = (tmp/100) * maxratio;
               continue;
            }

            money = money - (tmp/100) * (minratio+additionalRatio);

        }
        return money;
    }

    public static void main(String[] args) {

        System.out.println((21025667/100) * 7);
    }

}
