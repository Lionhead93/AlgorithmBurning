package com.company;

public class Day200406 {
    public static int romanToInt(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        answer -= 1;
                    } else {
                        answer += 1;
                    }
                    break;
                case 'V':
                    answer += 5;
                    break;
                case 'X':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        answer -= 10;
                    } else {
                        answer += 10;
                    }
                    break;
                case 'L':
                    answer += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        answer -= 100;
                    } else {
                        answer += 100;
                    }
                    break;

                case 'D':
                    answer += 500;
                    break;

                case 'M':
                    answer += 1000;
                    break;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        int iii = romanToInt("IXIXI");
        System.out.println(iii);
    }

}
