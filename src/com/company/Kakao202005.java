package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kakao202005 {
    public String solution(String play_time, String adv_time, String[] logs) {
        long ps = 3600 * Integer.parseInt(play_time.substring(0, 2)) + 60 * Integer.parseInt(play_time.substring(3, 5)) + Integer.parseInt(play_time.substring(6, 8));
        long as = 3600 * Integer.parseInt(adv_time.substring(0, 2)) + 60 * Integer.parseInt(adv_time.substring(3, 5)) + Integer.parseInt(adv_time.substring(6, 8));
        if (as >= ps) return "00:00:00";
        List<long[]> range = new ArrayList<>();
        for (String log : logs) {
            long[] pt = new long[2];
            pt[0] = 3600 * Integer.parseInt(log.substring(0, 2)) + 60 * Integer.parseInt(log.substring(3, 5)) + Integer.parseInt(log.substring(6, 8));
            pt[1] = 3600 * Integer.parseInt(log.substring(9, 11)) + 60 * Integer.parseInt(log.substring(12, 14)) + Integer.parseInt(log.substring(15, 17));
            range.add(pt);
        }
        //최대누적시간
        long max = 0;
        //광고시작시간
        long ast = Long.MAX_VALUE;
        for (int i = 0; i < range.size(); i++) {
            long cnt = 0;
            long[] rg = range.get(i);
            long et = rg[0] + as;
            if (et > ps) continue;
            if (et >= rg[1]) {
                cnt += rg[1] - rg[0];
            } else {
                cnt += et - rg[0];
            }
            for (int j = 0; j < range.size(); j++) {
                if (j == i) continue;
                long[] rg2 = range.get(j);
                //포함의 경우
                if (rg2[0] > rg[0] && rg2[1] < et) {
                    cnt += rg2[1] - rg2[0];
                    continue;
                }
                if (rg2[0] < rg[0] && rg2[1] > et) {
                    cnt += et - rg[0];
                    continue;
                }
                if (rg2[0] < rg[0] && rg2[1] > rg[0]) {
                    cnt += rg2[1] - rg[0];
                    continue;
                }
                if (rg2[0] < et && rg2[1] > et) {
                    cnt += et - rg2[0];
                    continue;
                }
            }
            if (cnt >= max) {
                max = cnt;
                if (ast > rg[0]) {

                    ast = rg[0];
                }
            }
        }
        //결과 시작시간,분,초
        String hh = String.valueOf((ast / 3600));
        while (hh.length() < 2) {
            hh = "0" + hh;
        }
        String mm = String.valueOf((ast % 3600) / 60);
        while (mm.length() < 2) {
            mm = "0" + mm;
        }
        String ss = String.valueOf((ast % 3600) % 60);
        while (ss.length() < 2) {
            ss = "0" + ss;
        }

        return hh + ":" + mm + ":" + ss;
    }

    public static void main(String[] args) {
        String log = "15:36:51-38:21:49";
    }
}

