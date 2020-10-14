package com.company;

import java.util.HashMap;
import java.util.Map;

public class Line202001 {

    public int solution(int[][] boxes) {

        int size = boxes.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<boxes.length;i++){
            map.put(boxes[i][0],map.getOrDefault(boxes[i][0],0)+1);
            map.put(boxes[i][1],map.getOrDefault(boxes[i][1],0)+1);
        }
        for(int k: map.keySet()){
            int v = map.get(k);
            if(size>0){
                size -= v/2;
            }
        }

        return size;
    }
}
