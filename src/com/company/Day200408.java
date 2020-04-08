package com.company;

public class Day200408 {

    /**
     * @author seongwou
     * @since 2020/04/08 3:29 오후
     * Implement atoi which converts a string to an integer.
     * <p>
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character,
     * takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     * <p>
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     * <p>
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters,
     * no conversion is performed.
     * <p>
     * If no valid conversion could be performed, a zero value is returned.
     * <p>
     * Note:
     * <p>
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values,
     * INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     **/
    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        } else {
            str = str.trim();
            if (str.length() < 1) {
                return 0;
            }
        }

        boolean isNegative = false;
        int index = 0;
        if (str.charAt(0) == '-') {
            isNegative = true;
            index++;
        } else if (str.charAt(0) == '+') {
            index++;
        }
        double result = 0.0;
        while (str.length() > index && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            result = (result * 10) + (str.charAt(index) - '0');
            index++;
        }

        if (isNegative) {
            result = -result;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-912834"));
    }

}
