package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Kakao202001 {

    /**
     * @author seongwou
     * @since 2020/09/12 1:35 오후
     * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다.
     * 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요.
     * 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
     * <p>
     * 제한사항
     * v는 세 점의 좌표가 들어있는 2차원 배열입니다.
     * v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
     * 좌표값은 1 이상 10억 이하의 자연수입니다.
     * 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
     **/
    public static int[] demo(int[][] v) {
        int[] answer = new int[2];
        Map<Integer, Boolean> xmap = new HashMap<>();
        Map<Integer, Boolean> ymap = new HashMap<>();
        for (int[] in : v) {
            xmap.put(in[0], !xmap.getOrDefault(in[0], false));
            ymap.put(in[1], !ymap.getOrDefault(in[1], false));
        }
        for (int xv : xmap.keySet()) {
            if (xmap.get(xv)) {
                answer[0] = xv;
            }
        }
        ;
        for (int yv : ymap.keySet()) {
            if (ymap.get(yv)) {
                answer[1] = yv;
            }
        }
        return answer;
    }

    public static String solution1(String new_id) {
        String answer = "";
        //소문자 치환
        String lowerCase = new_id.toLowerCase();
        //소문자,숫자,빼기,밑줄,마침표 필터링
        int[] filter = lowerCase.chars().filter(n ->
                ((n > 96) && (n < 123)) || (n > 47) && (n < 58) || (n == 95) || (n == 45) || (n == 46)
        ).toArray();
        //앞 . 제거 및 연속 . 제거
        StringBuilder removeComma = new StringBuilder(removeComma(filter));
        //빈문자열이라면 a 대입
        if (removeComma.length() < 1) removeComma = new StringBuilder("a");
        //16자 이상이라면 첫 15문자 제외하고 제거
        if (removeComma.length() > 15) {
            removeComma = new StringBuilder(removeComma.substring(0, 15));
            if (removeComma.charAt(14) == '.') removeComma.deleteCharAt(14);
        }
        //2자 이하라면 마지막 문자를 3이 될때까지 반복
        if (removeComma.length() < 3) {
            while (removeComma.length() < 3) {
                removeComma.append(removeComma.charAt(removeComma.length() - 1));
            }
        }

        return removeComma.toString();
    }

    public static String removeComma(int[] target) {
        StringBuilder tmp = new StringBuilder();
        //연속된 . 제거
        for (int i = 0; i < target.length; i++) {
            if (tmp.length() > 0 && tmp.charAt(tmp.length() - 1) == '.' && target[i] == '.') {
                continue;
            }
            tmp.append((char) target[i]);
        }
        //앞뒤 . 제거
        if (tmp.charAt(0) == '.') tmp.deleteCharAt(0);
        if (tmp.length() > 0 && tmp.charAt(tmp.length() - 1) == '.') tmp.deleteCharAt(tmp.length() - 1);
        return tmp.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution1("=.="));
    }
}
