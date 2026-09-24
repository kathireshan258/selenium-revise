package leetcode;

/**
 * STEP 0: Original Interview Question
 * Problem: Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input:
 * s = "abcabcbb"
 * Output:
 * 3
 * Explanation:
 * "abc"
 * is the longest substring without repeating characters.
 * Length: 3
 *
 * Example 2:
 * Input:
 * s = "bbbbb"
 * Output:
 * 1
 * Explanation:
 * "b"
 * is the longest substring without repeating characters.
 *
 * Example 3:
 * Input:
 * s = "pwwkew"
 * Output:
 * 3
 * Explanation:
 * "wke"
 * Length:
 * 3
 *
 * Constraints:
 * 0 <= s.length <= 50000
 * s consists of English letters, digits, symbols and spaces.
 * */


/**
 * The problem actually asks to find the "Longest "continuous" substring that contains no duplicates"
 * We are finding a range in the string whose length is maximum.
 * */


/**
 * Most people think:
 * Character enter, Character leave -> need queue
 * But if we already know:
 * left index and right index
 * then:
 * Hashset + two indices is enough
 *
 * Discovery chain:
 * Need the longest valid substring -> Duplicate makes window invalid ->
 * Need to know whether the character already exist -> Need add/remove/contains -> HashSet
 * */

/**
 * Important optimization principle:
 * When new information arrives, don't recompute everything. Ask whether the new information violated an existing invariant.
 * */

import java.util.HashSet;
import java.util.Set;

/**
 * Key insight:
 * The string itself already stores the order.
 * The pointers tell us exactly which character enters and leaves.
 * The HashSet only remembers membership.
 * That's a very important design insight:
 * " A data structure should store only the information it is responsible for.
 * HashSet stores membership.
 * Pointers store position.
 * The string stores order."
 *
 * Before adding or finalizing a data structure think and ask:
 * What information or operation does this data structure provide that I don't already have?
 *
 * If the answer is:
 * nothing new
 * then think about different data structure if needed or the data structure is probably unnecessary.
 * */

class SlidingWindow {
    static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString(s));
    }

    private static int lengthOfLongestSubString(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
        }
        return maxLength;
    }
}

/**
 * Clue 1:
 * Longest
 * Shortest
 * Maximum
 * Minimum
 *
 * Over a:
 * continuous subarray
 * continuous substring
 *
 * Immediately ask:
 * Can I maintain a window?
 *
 * Clue 2:
 * The window can become:
 * valid
 * Invalid
 * Ask:
 * Can I repair the window instead of rebuilding it?
 *
 * Clue 3:
 * Have I already seen this element?
 * Think:
 * HashSet
 * HashMap
 *
 * Clue 4:
 * Ask:
 * What causes invalidity?
 * Here:
 * Duplicate character, not the whole substring
 *
 * Takeaway:
 * Longest substring without repeating characters -> Sliding window + HashSet
 *
 * Remember the discovery chain:
 * Need longest valid substing -> Duplicate causes invalidity -> Need to know which characters are currently inside ->
 * Repeated Operations: "Does character already exist?" -> HashSet -> Expand with right -> when invalid, remove information from the left
 * until valid again -> Keep best answer seen so far
 *
 * */
