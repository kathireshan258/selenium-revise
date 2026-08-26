package leetcode;

/**
 * Problem 1: Valid Anagram (HashMap / Counting Pattern)
 * Problem Statement:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An anagram is a word or phrase formed by rearranging the letters of another word, using all original letters exactly once.
 * Input:
 * - String s
 * - String t
 * Output:
 * true if t is an anagram of s
 * false otherwise
 *
 * Example 1:
 * Input:
 * s = "anagram"
 * t = "nagaram"
 * Output:
 * true
 * Explanation:
 * Both strings contain exactly the same characters with exactly the same frequencies.
 *
 * Example 2:
 * Input:
 * s = "abc"
 * t = "abcdef"
 * Output:
 * false
 *
 * Explanation:
 * Rearranging the letters of one string should produce the other string using **all letters exactly once**.
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 *
 * Guarantees:
 * Only lowercase English letters are present.
 * Lengths can be different.
 * We must determine whether both strings contain the same characters the same number of times.
 * */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Anagram {
    static void main(String[] args) {
        String s = "aabb";
        String t = "abab";
        System.out.printf("String %s and %s is anagram %b%n", s, t, isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        // Build the first map for string s to store the character -> frequency count
        for (int i =0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }

        // Print sMap
        System.out.printf("Printing %s::%n", "sMap");
        sMap.forEach((k, v) -> {
            System.out.printf("%s: %d%n", k, v);
        });

        // Now we have sMap with characters and frequency, now check with String t if the characters and frequencies are exactly same
        for (int i = 0; i < t.length(); i++) {
            if (sMap.containsKey(t.charAt(i))) {
                sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
                if (sMap.get(t.charAt(i)) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
