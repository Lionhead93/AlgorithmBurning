package com.company;

public class Day200423 {
    public int reverse(int x) {
        boolean minus = false;
        if (x < 0) minus = true;

        double answer = 0;

        while (x / 10 != 0) {
            int tmp = x % 10;
            answer = (answer * 10) + tmp;
            x = x / 10;
        }

        if (answer > Integer.MAX_VALUE) return 0;

        return minus ? (int) answer * -1 : (int) answer;

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";

        StringBuilder answer = new StringBuilder();
        int idx = 0;
        boolean flag = true;

        while (flag) {

            char common = '-';

            for (String s : strs) {
                if (s.length() - 1 < idx) {
                    return answer.toString();
                } else {
                    if (common == '-') common = s.charAt(idx);
                    else if (common != s.charAt(idx)) {
                        flag = false;
                    }
                }
            }

            idx++;
            answer.append(common);
        }

        return answer.toString();

    }

    public String masking(String s) {
        String answer = "";

        for (int i = 0; i < s.length() - 4; i++) {
            answer += "*";
        }

        return answer.concat(s.substring(s.length() - 4, s.length()));
    }

}
