package leetcode;

/**
 * Problem: 3Sum
 * Given an integer array nums, return all the unique triplets [nums[i], nums[j], nums[k]] such that:
 *
 * i != j
 * i != k
 * j != k
 * nums[i] + nums[j] + nums[k] == 0
 *
 * The solution set must not contain duplicate triplets.
 *
 * Input:
 * A list of all unique triplets whose sum is 0.
 *
 * Example 1:
 * Input:
 * nums = [-1,0,1,2,-1,-4]
 * Output:
 * [[-1,-1,2],[-1,0,1]]
 *
 * Explanation:
 * (-1) + (-1) + 2 = 0
 * (-1) + 0 + 1 = 0
 * No other unique triplets sum to 0.
 *
 * Example 2:
 * Input:
 * nums = [0,1,1]
 * Output:
 * []
 *
 * Explanation:
 * No three numbers sum to 0.
 *
 * Example 3:
 * Input:
 * nums = [0,0,0]
 * Output:
 * [[0,0,0]]
 *
 * Explanation:
 * The only possible triplet sums to 0.
 *
 * Constraints:
 * 3 <= nums.length <= 3000
 * -100000 <= nums[i] <= 100000
 *
 * Guarantees:
 * Input can contain negative numbers.
 * Input can contain duplicates.
 * Output must contain only unique triplets.
 * Order of triplets does not matter.
 * Order of numbers inside a triplet does not matter.
 * */

class ThreeSum {
}
