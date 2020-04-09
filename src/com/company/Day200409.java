package com.company;

public class Day200409 {

    /**
     * @author seongwou
     * @since 2020/04/09 2:33 오후
     * <p>
     * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     **/
    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();

        int i = 0, j = 0;

        while (i < ch.length) {
            while (i < ch.length && ch[i] == ' ') i++;
            j = i;
            while (j < ch.length && ch[j] != ' ') j++;
            reverseWord(ch, i, j);
            i = j;
        }


        return new String(ch);
    }

    public static void reverseWord(char[] c, int st, int end) {
        while (st < end) {
            char tmp = c[st];
            c[st++] = c[end];
            c[end--] = tmp;
        }
    }

    /**
     * @author seongwou
     * @since 2020/04/09 3:36 오후
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     * <p>
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     * <p>
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     **/
    public int[] plusOne(int[] digits) {
        int carry = 1, flag = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = (digits[i] + carry);
            digits[i] = sum % 10;
            carry = sum / 10;
            if (i == 0 && carry == 1)
                flag = 1;
        }
        if (flag == 1) {
            int ans[] = new int[digits.length + 1];
            for (int i = 1; i < ans.length; i++)
                ans[i] = digits[i - 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }

}
