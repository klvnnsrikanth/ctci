package com.sk.chap01;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1.2 Given two strings write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {
    /**
     * Checks if source is a permutation of the target
     * @param source input string
     * @param target input string
     * @return true if source is permutation of target else false
     */
    private static boolean isPermutation(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }

        Map<Character, Integer> sourceCountMap = getCharCounts(source);

        for (char ch : target.toCharArray()) {
            if (!sourceCountMap.containsKey(ch)) {
                return false;
            }
            sourceCountMap.computeIfPresent(ch, (k, v) -> v--);

            if (sourceCountMap.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharCounts(String input) {
        return input
            .chars()
            .boxed()
            .collect(
                Collectors.toMap(
                    k -> (char) k.intValue(),
                    v -> 1,
                    Integer::sum
                )
            );
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("madam", "admam"));
        System.out.println(isPermutation("pen", "pencil"));
        System.out.println(isPermutation("adam", "adom"));
    }
}
