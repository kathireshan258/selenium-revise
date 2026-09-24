package leetcode;

/**
 * Problem: Group Anagrams
 * Given an array of strings strs, group the anagram toghether
 * You may return the answer in any order
 *
 * Input:
 * strs = arrays of strings
 * Output:
 * List of groups where each group contains strings that are
 * anagram of each other
 *
 * Example 1:
 * Input:
 * strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output:
 * [
 *  ["eat","ate","tea"],
 *  ["tan","nat"],
 *  ["bat"]
*  ]
 *
 *  Example 2:
 *  Input:
 *  strs = [""]
 *  Output:
 *  [
 *    [""]
*   ]
 *
 * Example 3:
 * Input:
 * strs = ["s"]
 * Output:
 * [
 *  ["a"]
*  ]
 *
 * Constraints:
 * 1 <= strs.length <= 10000
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters
 *
 * Guarantees:
 * - Angram contain exactly the same characters
 * - Character frequency are identical
 * - only the order changes
 * - Need to return groups, no just determine whether a pair is an anagram
 * */

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class GroupAnagrams {

    static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // Created a unique identity key by sorting characters.
            // so that no matter how different the characters are set, on sorting everything is ordered in same
            // Another unique identity key method is creating a character frequency key.
            // Example: a1b2c1, a1b1c1 but the current approach is much more simple than that.
            String sorted = Arrays.toString(chars);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

/**
 * Clue1:
 * When the problem says "Group similar items"
 * Ask:
 * What makes two items below to the same group.
 *
 * Clue2:
 * Ask:
 * What information remains unchanged?
 * For anagrams:
 * Character Frequencies
 *
 * Clue3:
 * Ask:
 * Can I create a stable identity
 * Example:
 * eat -> aet
 * tea -> aet
 * ate -> aet
 *
 * Clue4:
 * Ask:
 * Do I repeatedly need
 * Identity -> collection of items
 * If yes, think
 * HashMap
 *
 *
 * Discovery Chain:
 * Need to group words -> What determines the group? -> Character frequencies ->
 * Need a stable identity -> Sorting string creates identical identity for all anagrams
 * -> Need identity => group lookup -> HashMap
 *
 *
 *
 * Suppose if the problem says the strings contain only lower case characters from a-z
 * Then even simpler we can create. Alphabets has 26 characters.
 * We just need character and its frequency to identify if it is anagram
 * so we can just use array with values like [a_1,b_2] or [a:1,b:2]
 * This is much more optimized because
 * IMPORTANT:
 * for a word with characters of 'k' cost more than the array approach.
 * Sorting cost O(k log k) where k is number of characters.
 * and for counting frequencies cost O(k) because you just scan once.
 * */
