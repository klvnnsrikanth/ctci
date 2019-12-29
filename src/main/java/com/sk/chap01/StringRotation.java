package com.sk.chap01;

/**
 * 1.9 Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings s1 and s2, write code to check if s2 is a rotation of s1 using only one call
 * to isSubstring
 */
public class StringRotation {
    private static boolean isRotation(String s1, String s2) {
        int length = s1.length();
        if (length == 0 || length != s2.length()) {
            return false;
        }

        String s1s1 = s1 + s1;

        return isSubstring(s1s1, s2);
    }

    private static boolean isSubstring(String source, String target) {
        return source.contains(target);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
        System.out.println(isRotation("waterbottle", "abcd"));
        System.out.println(isRotation("cdab", "abcd"));
    }
}
