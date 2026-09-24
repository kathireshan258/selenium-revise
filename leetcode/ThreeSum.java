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

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class ThreeSum {
    static void main (String[] args) {
        int[] arr = {-2, 0, 0, 2, 2};
        List<List<Integer>> result = threeSum(arr);
        printResult(result, arr);
        arr = new int[] {-4, -1, -1, 0, 1, 2};
        result = threeSum(arr);
        printResult(result, arr);
    }
    private static void printResult(List<List<Integer>> result, int[] nums) {
//        System.out.println("Results for " + Arrays.deepToString(result.toArray()));
        System.out.println("Results for " + Arrays.toString(nums));
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate 'a'
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;
                    // skip duplicate left values
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // skip duplicate right values
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return result;
    }
}
