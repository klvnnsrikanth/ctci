package com.sk.chap01;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1.5 There are three types of edits that can be performed on strings:
 * insert a character,
 * remove a character,
 * replace a character
 * Given two strings, write a function to check if they are one edit (or zero edits) away
 */
public class OneAway {
    private static boolean isOneEditAway(String source, String target) {
        if (source.length() == target.length()) {
            return isOneCharReplace(source, target);
        } else if (source.length() == target.length() + 1) {
            return isOneCharRemove(source, target);
        } else if (source.length() + 1 == target.length()) {
            return isOneCharRemove(target, source);
        }
        return false;
    }

    private static boolean isOneCharRemove(String input1, String input2) {
        Map<Character, Long> input1CountMap = getCharCount(input1);

        for (char ch : input2.toCharArray()) {
            input1CountMap.computeIfPresent(ch, (k,v) -> v = v -1);
        }

        return input1CountMap.entrySet().stream().filter(e -> e.getValue() == 1).count() == 1;
    }

    private static Map<Character, Long> getCharCount(String input) {
        return input.chars()
            .mapToObj(i -> (char) i)
            .map(Character::toLowerCase)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static boolean isOneCharReplace(String source, String target) {
        int replacedCount = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                replacedCount++;
            }
            if (replacedCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pale", "pales"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bae"));
        System.out.println(isOneEditAway("tales", "pale"));
        System.out.println(isOneEditAway("ales", "pale"));
        System.out.println(isOneEditAway("sale", "pale"));
    }
}
