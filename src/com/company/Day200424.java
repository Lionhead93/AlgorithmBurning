package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day200424 {

    /**
     * @author seongwou
     * @since 2020/04/24 9:43 오전
     * <p>
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     **/
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {


        if (digits.length() < 1) return answer;

        helper(digits, "");

        return answer;
    }

    public void helper(String digits, String target) {

        if (digits.length()==0) {
            answer.add(target);
            return;
        }
        String buttons = map.get(digits.charAt(0));

        for (int i = 0; i < buttons.length(); i++) {
            helper(digits.substring(1), target + buttons.charAt(i));
        }

    }

}
