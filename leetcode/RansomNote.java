package leetcode;

/**
 * Problem: Ransom Note
 * Problem Statement:
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed using the letters from
 * magazine, otherwise return false.
 * Each letter in magazine can only be used once in ransomNote.
 * Input:
 * ransomNote = String
 * magazine = String
 * Output:
 * true -> if ransomeNote can be constructed
 * false -> otherwise
 *
 * Example1:
 * Input:
 * ransomNote = "a"
 * magazine = "b"
 * Output:
 * false
 * Explanation:
 * Magazine does not contain the required character 'a'.
 *
 * Example2:
 * Input:
 * ransomNote = "aa"
 * magazine = "ab"
 * Output:
 * false
 * Explanation:
 * Magazine contains only 1 'a', but ransom note needs two.
 *
 * Example3:
 * Input:
 * ransomNote = "aa"
 * magazine - "aab"
 * Output:
 * true
 * Explanation:
 * Magazine contains enough occurrences of every required character.
 *
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consists of lowercase English letters.
 * */

import java.util.Map;
import java.util.HashMap;

class RansomNote {
    static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.printf("can we construct ransomNote from magazine::%s%n", canConstruct(ransomNote, magazine));
        ransomNote = "aaa";
        magazine = "aab";
        System.out.printf("can we construct ransomNote from magazine::%s%n", canConstruct(ransomNote, magazine));
        ransomNote = "abd";
        magazine = "abc";
        System.out.printf("can we construct ransomNote from magazine::%s%n", canConstruct(ransomNote, magazine));
        ransomNote = "aaa";
        magazine = "abacad";
        System.out.printf("can we construct ransomNote from magazine::%s%n", canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (ransomNote.isEmpty() || magazine.isEmpty() || ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c: magazine.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (char c: ransomNote.toCharArray()) {
            if (!frequencyMap.containsKey(c)) {
                return false;
            }

            frequencyMap.put(c, frequencyMap.get(c) - 1);
            if (frequencyMap.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
