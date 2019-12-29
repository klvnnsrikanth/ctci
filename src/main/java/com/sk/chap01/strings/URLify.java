package com.sk.chap01.strings;

/**
 * 1.3 Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string.
 * (Note: if implementing in JAVA, please use a character array so that you can perform the operation in place)
 */
public class URLify {
    private static void urlEncodeForSpaces(char[] input, int trueLength) {
        int index = input.length - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[index] = '0';
                input[index - 1] = '2';
                input[index - 2] = '%';
                index -= 3;
            } else {
                input[index] = input[i];
                index -= 1;
            }
        }
    }

    public static void main(String[] args) {
        char[] input = "Mr John Smith    ".toCharArray();
        urlEncodeForSpaces(input, 13);
        System.out.println(input);

        char[] input2 = " Hello World!!    ".toCharArray();
        urlEncodeForSpaces(input2, 14);
        System.out.println(input2);
    }
}
