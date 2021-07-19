package com.company;

import java.math.BigDecimal;

public class Day210719 {

    public int solution(String[] lines) {
        int answer = 0;

        // 각 요청 시작, 끝 부터 1초 계산
        for (int i = 0; i < lines.length; i++) {

            String std = lines[i];

            String stdComplete = std.split(" ")[1];
            int stdEnd = toMillies(stdComplete);
            BigDecimal processing = new BigDecimal(std.split(" ")[2].replace("s", ""))
                    .multiply(BigDecimal.valueOf(1000));

            int stdStart = stdEnd - processing.intValue();

            answer = Math.max(answer, Math.max(compareProcessing(lines, stdEnd), compareProcessing(lines, stdStart)));
        }

        return answer;
    }

    private int compareProcessing(String[] lines, int millies) {

        int cpStart = millies;
        int cpEnd = cpStart + 999;

        int cnt = 0;

        for (String s : lines) {

            String complete = s.split(" ")[1];
            int end = toMillies(complete);
            BigDecimal processing = new BigDecimal(s.split(" ")[2].replace("s", ""))
                    .multiply(BigDecimal.valueOf(1000));

            int start = end - processing.intValue();

            if (start >= cpStart && end <= cpEnd
                    || end <= cpEnd && end >= cpStart
                    || start <= cpEnd && start >= cpStart
                    || start <= cpStart && end >= cpEnd ) {
                System.out.println(start + " ~ " + end + " // " + cpStart + "~" + cpEnd);
                cnt++;
            }

        }
        return cnt;
    }

    private int toMillies(String completeTime) {
        String completeMillis = completeTime.split("\\.")[1];
        String completeWithoutMillis = completeTime.split("\\.")[0];


        return 60 * 60 * 1000 * (Integer.parseInt(completeWithoutMillis.split(":")[0]))
                + 60 * 1000 * (Integer.parseInt(completeWithoutMillis.split(":")[1]))
                + 1000 * (Integer.parseInt(completeWithoutMillis.split(":")[2]))
                + Integer.parseInt(completeMillis);
    }

    public static void main(String[] args) {
        String s = "2.010s";
        BigDecimal decimal = new BigDecimal(s.replace("s", ""));
        System.out.println(decimal.multiply(BigDecimal.valueOf(1000)));
    }

}
