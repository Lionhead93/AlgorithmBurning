package com.company;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author seongwou
 * @since 2020/04/14 2:05 오후
 * <p>
 * Design an Iterator class, which has:
 * <p>
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 **/
public class CombinationIterator {

    private Queue<String> combi = new LinkedList<>();

    public CombinationIterator(String characters, int combinationLength) {

        combination(combi, characters, combinationLength, 0, "");

    }

    public void combination( Queue<String> combi, String characters, int combinationLength, int index, String target) {

        if( target.length() == combinationLength ) {
            System.out.println(target);
            combi.add(target);
        } else {
            if(index == characters.length()) return;
            combination(combi, characters, combinationLength, index+1, target + characters.charAt(index));
            combination(combi, characters, combinationLength, index+1, target);
        }


    }

    public String next() {
        return combi.poll();
    }

    public boolean hasNext() {
        return !combi.isEmpty();
    }

    /*
     * Your CombinationIterator object will be instantiated and called as such:
     * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
     * String param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
