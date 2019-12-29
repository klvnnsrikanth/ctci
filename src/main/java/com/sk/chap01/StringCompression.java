package com.sk.chap01;

/**
 * 1.6 Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You can assume the string has only
 * uppercase and lowercase letters (a-z)
 */
public class StringCompression {
    private static String compressString(String input) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i ++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                sb.append(input.charAt(i)).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(input.charAt(input.length() - 1)).append(count); //add the last char count as well

        if (sb.length() > input.length()) {
            return input;
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abcdefgh"));
        System.out.println(compressString("aabccccca"));
    }
}
