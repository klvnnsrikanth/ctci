package com.sk.chap01;

import java.util.HashSet;

/**
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 */
public class IsUnique {
    /**
     * Using a data structure
     * @param str input string
     * @return true if input has unique chars else false
     */
    private static boolean hasUniqueChars(String str) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcdef"));
        System.out.println(hasUniqueChars("abcdeab"));
    }
}
