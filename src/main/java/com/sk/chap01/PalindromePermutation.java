package com.sk.chap01;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1.4 Given a string write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * Example:
 * Input: Tact Cao
 * Output: True
 */
public class PalindromePermutation {
    private static boolean isPermutationAPalindrome(String input) {
        Map<Character, Long> countMap = input
            .chars()
            .mapToObj(i -> (char) i)
            .filter(ch -> ch != ' ')
            .map(Character::toLowerCase)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int countOdd = 0;

        for (Map.Entry<Character, Long> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }

        return countOdd <= 1;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationAPalindrome("Tact Cao"));
        System.out.println(isPermutationAPalindrome("madam"));
        System.out.println(isPermutationAPalindrome("abcde"));
    }
}
