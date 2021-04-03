package com.company.test210403;

import java.util.ArrayList;
import java.util.List;

import static com.company.Day210330.list;

public class Solution2 {

    public int solution(int[][] needs, int r) {
        int answer = 0;

        int[] parts = new int[needs[0].length];
        for (int i = 0; i < parts.length; i++) {
            parts[i] = i;
        }
        boolean[] visited = new boolean[parts.length];
        List<List<Integer>> lists = new ArrayList<>();
        combination(parts, visited, 0, parts.length, r, lists);

        for (List<Integer> list : lists) {
            int[] buyParts = new int[needs[0].length];
            for(int i : list) {
                buyParts[i] = 1;
            }
            int cnt = 0;
            for(int[] need: needs) {
                boolean flag = true;
                for(int i=0; i<need.length; i++) {
                    if(need[i] == 1 && buyParts[i] == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    cnt++;
                }
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    public static void combination(int[] parts, boolean[] visited, int idx, int n, int r, List<List<Integer>> lists) {
        if (r == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    list.add(parts[i]);
                }
            }
            lists.add(list);
            return;
        }

        if (idx == n) {
            return;
        }

        visited[idx] = true;
        combination(parts, visited, idx + 1, n, r - 1, lists);
        visited[idx] = false;
        combination(parts, visited, idx + 1, n, r, lists);
    }

    public static void main(String[] args) {
        solution2();
    }

    public static int[] solution2() {
        int[] parts = {1, 2, 3, 4, 5, 6, 7, 8};
        boolean[] visited = new boolean[parts.length];
        List<List<Integer>> lists = new ArrayList<>();
        // str 중 2개만 뽑는경우
        combination(parts, visited, 0, parts.length, 4, lists);
        System.out.println(lists);
        return null;
    }

}
