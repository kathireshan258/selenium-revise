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

class SubArraySumK {
}

/**
 * Discovery Chain:
 * Subarray sum = CurrentPrefix - PreviousPrefix
 * We want
 * Subarray = k
 * therefore
 * CurrentPrefix - PreviousPrefix = k
 * PreviousPrefix = CurrentPrefix - k
 *
 * Which means
 * for every position CurrentPrefix
 * we ask
 * have I already seen (CurrentPrefix - k)
 * if yes
 * A valid subarray exists.
 * if it appeared multiple times:
 * multiple valid subarray exist.
 * HashMap<PrefixSum, Frequency>
 * */