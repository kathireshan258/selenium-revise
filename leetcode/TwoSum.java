package leetcode;

import java.util.Arrays;
import java.util.HashMap;


/**
 * Problem 1: Two Sum (Most Frequently Asked)
 * Problem Statement
 * Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to target.
 * Example:
 * Input:
 * nums = [2,7,11,15]
 * target = 9
 *
 * Output:
 * [0,1]
 * */

class TwoSum {
    static void main(String[] args) {
        int[] result = usingHashMap(new int[]{2,5,8,11,14,3}, 16);
        System.out.println(Arrays.toString(result));
    }

    static int[] usingHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
