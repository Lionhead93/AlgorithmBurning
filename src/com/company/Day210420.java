package com.company;

import java.util.HashMap;
import java.util.Map;

public class Day210420 {

    static int equalizeArray(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();

        int[] c = new int[101];
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
            c[i]++;
        }

        int max = 0;

        for(Integer i : map.keySet()) {
            max = Math.max(map.get(i), max);
        }

        return arr.length - max;

    }

    static int[] rotLeft(int[] a, int d) {

        d = (d%a.length);
        for(int j=0; j<d; j++) {
            int first = a[0];
            for(int i=0; i<a.length-1; i++) {
                a[i] = a[i+1];
            }
            a[a.length-1] = first;
        }

        return a;
    }

}
