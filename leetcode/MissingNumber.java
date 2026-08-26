package leetcode;

import java.util.HashSet;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * Example:
 * Input: nums = [3,0,1]
 * Output: 2
 *
 *
 * */


class MissingNumber {
    static void main (String[] args) {
        System.out.println(missingNumber(new int[] {0, 1, 3}));
        System.out.println(missingNumber(new int[] {0, 1, 3}));
    }

    static int missingNumber (int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    static int missingNumber1 (int[] nums) {
        int n = nums.length;
        int actualSum = 0;
        int expectedSum = n*(n+1)/2;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

}
