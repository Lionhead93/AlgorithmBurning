package com.company;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test210423 {

    public static List<String> solution(List<List<String>> arr) {
        // Write your code here

        Map<String, Integer> history = new HashMap<>();

        for(List<String> row: arr) {
            int m = history.getOrDefault(row.get(0), 0) - Integer.parseInt(row.get(2));
            int p = history.getOrDefault(row.get(1), 0) + Integer.parseInt(row.get(2));
            history.put(row.get(0), m);
            history.put(row.get(1), p);
        }

        List<String> answer = new ArrayList<>();

        int min = 0;

        for(String key : history.keySet()) {

            int point = history.get(key);

            if(point > -1) {
                continue;
            }

            if(point == min) {
                answer.add(key);
            } else if(point < min) {
                answer = new ArrayList<>();
                answer.add(key);
                min = point;
            }

        }

        answer.sort(null);

        return answer.isEmpty() ? Arrays.asList("None") : answer;

    }
    public static List<String> solution2(List<List<String>> items, int orderBy, int orderDirection, int pageSize, int pageNumber) {
        // Write your code here

        if(orderBy == 0) {
            items.sort(Comparator.comparing(
                    list -> list.get(0), (s1, s2) -> {
                        return orderDirection == 0 ? s1.compareTo(s2) : s2.compareTo(s1);
                    }));
        } else {
            items.sort(Comparator.comparing(
                    list -> list.get(orderBy), (s1, s2) -> {
                        return orderDirection == 0 ? Integer.parseInt(s1) - Integer.parseInt(s2)
                                : Integer.parseInt(s2) - Integer.parseInt(s1) ;
                    }));
        }


        List<String> answer = new ArrayList<>();

        int i = pageSize*pageNumber;

        while(i < items.size() && answer.size() < pageSize) {
            answer.add(items.get(i).get(0));
            i++;
        }

        return answer;

    }

    public static int solution3(List<Integer> start_time, List<Integer> running_time) {
        // Write your code here

        int answer = 0;

        Map<Integer, Integer> map= new HashMap<>();

        for(int i=0; i<start_time.size(); i++) {
            int start = start_time.get(i);
            if(map.getOrDefault(start, 1001) > running_time.get(i)) {
                map.put(start, running_time.get(i));
            }
        }

        int end_at = 0;

        List<Integer> keys = new ArrayList<>(map.keySet());

        keys.sort((i,j) -> {
            return (i + map.get(i)) - (j + map.get(j));
        });

        for(Integer key : keys) {
            if(key < end_at) {
                continue;
            }
            end_at = key + map.get(key);
            answer++;
        }

        return answer;
    }


}
