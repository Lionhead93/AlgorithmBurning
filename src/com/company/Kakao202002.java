package com.company;

import java.util.*;

public class Kakao202002 {

    public String[] solution(String[] orders, int[] course) {
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            int choice = course[i];
            Map<String, Integer> cntMap = new HashMap<>();
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                order = new String(chars);
                if (order.length() < choice) continue;
                helper(order.toCharArray(), new boolean[order.length()], 0, order.length(), choice, cntMap);
            }
            int cntMax = 0;
            for (String key : cntMap.keySet()) {
                cntMax = cntMap.get(key) > cntMax ? cntMap.get(key) : cntMax;
            }
            if (cntMax > 1) {
                for (String key : cntMap.keySet()) {
                    if (cntMap.get(key) == cntMax) {
                        resultList.add(key);
                    }
                }
            }
        }
        resultList.sort(String::compareTo);
        System.out.println(resultList);
        String[] answer = new String[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    void helper(char[] order, boolean[] visited, int start, int n, int r, Map<String, Integer> cntMap) {
        if (r == 0) {
            String result = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    result += order[i];
                }
            }
            cntMap.put(result, cntMap.getOrDefault(result, 0) + 1);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            helper(order, visited, i + 1, n, r - 1, cntMap);
            visited[i] = false;
        }
    }
}
