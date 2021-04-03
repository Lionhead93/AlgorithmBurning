package com.company.test210403;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        Map<Integer, Integer> gift_map = new HashMap<>();
        for(int i : gift_cards) {
            gift_map.put(i, gift_map.getOrDefault(i, 0)+1);
        }
        for(int i: wants) {
            if(gift_map.getOrDefault(i, 0) == 0) {
                answer++;
            } else {
                gift_map.put(i, gift_map.get(i)-1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }

}
