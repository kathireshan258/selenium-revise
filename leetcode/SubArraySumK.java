package leetcode;

/**
 * Problem: Subarray Sum Equals K
 * Given an array of integer nums and an integer k, return the total number of continuous
 * subarray whose sum equals k
 *
 * Input:
 * nums = integer array
 * k = target sum
 * Output:
 * Number of continuous sub array whose sum equals k
 *
 * Example 1:
 * Input:
 * nums = [1,1,1]
 * k = 2
 * Output
 * 2
 * Explanation:
 * Subarrays:
 * [1,1] -> sum = 2
 * [1,1] -> sum = 2
 * Answer: 2
 *
 * Example 2:
 * Input:
 * nums = [1,2,3]
 * k = 3
 * Output:
 * 2
 * Explanation:
 * [1,2]
 * [3]
 * Answer: 2
 *
 * Constraints:
 * 1 <= nums.length <= 20000
 * -1000 <= nums[i] <= 1000
 * -10000000 <= k <= 10000000
 *
 * Guarantees:
 * Subarray means continuous elements
 * Numbers may be positive
 * Numbers may be negative
 * Multiple valid subarrays may exist
 * Need count, not the actual subarray
 * */

import java.util.Map;
import java.util.HashMap;

class SubArraySumK {
    static void main(String[] args) {
        // Test with your favorite example
        int[] nums = {4, 2, 1, 3};
        int target = 3;
        System.out.println("Total Subarrays: " + subArraySum(nums, target)); // Output: 1
    }

    private static int subArraySum(int[] nums, int target) {
        // 1. Initialize our historical memory map
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1); // Ground truth: a prefix sum of 0 has appeared 1 time

        int currentPrefix = 0;
        int numOfSubArr = 0;

        // 2. Walk through the array from left to right
        for (int i = 0; i < nums.length; i++) {
            // Update our current running position total
            currentPrefix += nums[i];

            // Calculate the exact target chop-point we need from the past
            int previousPrefix = currentPrefix - target;

            // 3. Counting Logic: If our chop-point exists in history, add its frequency
            if (prefixSums.containsKey(previousPrefix)) {
                numOfSubArr += prefixSums.get(previousPrefix);
            }

            // 4. Recording Logic: Blindly save our current position for the future
            prefixSums.put(currentPrefix, prefixSums.getOrDefault(currentPrefix, 0) + 1);
        }

        return numOfSubArr;
    }
}
