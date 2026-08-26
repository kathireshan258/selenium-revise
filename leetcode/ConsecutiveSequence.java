package leetcode;

/**
 * Problem: Longest Consecutive Sequence
 * This is one of the most important HashSet interview problems because many candidates initially think:
 * Sort the array
 * But interviewers usually want you to discover a better approach.
 *
 * Original Interview Question
 * Problem Statement:
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in:
 * O(n)
 * time
 *
 * Input:
 * nums = integer array
 * Output:
 * Length of the longest consecutive sequence
 *
 * Example 1:
 * Input:
 * nums = [100,4,200,1,3,2]
 * Output:
 * 4
 * Explanation:
 * The consecutive sequence is:
 * 1,2,3,4
 * Length:
 * 4
 *
 * Example 2:
 * Input:
 * nums = [0,3,7,2,5,8,4,6,0,1]
 * Output:
 * 9
 * Explanation:
 * The consecutive sequence is:
 * 0,1,2,3,4,5,6,7,8
 * Length:
 * 9
 *
 * Example 3:
 * Input:
 * nums = [1,0,1,2]
 * Output:
 * 3
 * Explanation:
 * Consecutive sequence:
 * 0,1,2
 * Length:
 * 3
 *
 * Important Constraints:
 * 0 <= nums.length <= 100000
 * -10^9 <= nums[i] <= 10^9
 *
 * Very important requirement:
 * The problem explicitly asks for:
 * O(n)
 * time. Keep that in the back of your mind.
 * */

import java.util.HashSet;
import java.util.Set;

class ConsecutiveSequence {
    static void main(String[] args) {
        int[] nums = {1,2,3,10,11,50,51,100};
        System.out.println(longestConsecutive(nums));
        nums = new int[]{1, 3, 11, 12, 14, 16, 17, 18, 19, 20, 21, 50, 51, 52, 53, 100, 101, 102};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // add the items from the array to set to prevent duplicates and easy lookups
        for (int num: nums) {
            set.add(num);
        }

        int longest = 0;
        for(int num: set) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum+1)) {
                    currentNum ++;
                    currentLength++;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }
}
