package leetcode;

/**
 * Problem: First Unique Character in a String
 * Problem Statement:
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 * Input:
 * A String s
 * Output:
 * An integer representing the index of the first unique character.
 * If no unique character exists, return -1.
 *
 * Example 1:
 * Input:
 * s = "leetcode"
 * Output:
 * 0
 * Explanation:
 * l -> appeared once
 * e -> appeared thrice
 * t -> appeared once
 * c -> appeared once
 * o -> appeared once
 * d -> appeared once
 * The first unique character is "l" at index 0
 *
 * Example 2:
 * Input:
 * s = "loveleetcode"
 * Output:
 * 2
 * Explanation:
 * The first unique character is v
 *
 * Example 3:
 * Input:
 * s = "aabb"
 * Output:
 * -1
 * Explanation:
 * Every character repeats
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s contains of lowercase English letters
 * */

import java.util.HashMap;

class UniqueCharacter {
    static void main(String[] args) {
        String word = "mississippi";
        System.out.printf(word + ": %d%n", uniqueCharacter(word));
        word = "aabc";
        System.out.printf(word + ": %d%n", uniqueCharacter(word));
    }

    private static int uniqueCharacter(String word) {
        HashMap<Character, Integer> freq = new HashMap<>();
        // Build the character frequency map
        for (char c: word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i =0; i < word.length(); i++) {
            if(freq.get(word.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
