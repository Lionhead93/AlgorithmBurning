package com.company;


public class Day200318 {

    /**
     * <p>
     * Students are asked to stand in non-decreasing order of heights for an annual photo.
     * <p>
     * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
     * <p>
     * Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
     **/
    public static int heightChecker(int[] heights) {

        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }

        return result;
    }

    /**
     * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
     * <p>
     * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
     **/
    public static boolean isLongPressedName(String name, String typed) {

        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        int i = heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        System.out.println(i);
        boolean b = isLongPressedName("alex", "aaleex");
        System.out.println(b);
    }

}
