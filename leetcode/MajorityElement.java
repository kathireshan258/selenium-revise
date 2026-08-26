package leetcode;

import java.util.HashMap;

/**
 * Given an integer array nums, return the element that appears more than n/2 times, where n is the size of the array.
 * (LeetCode 169)
 * */

class MajorityElement {
    static void main (String[] args) {
        System.out.println(majorityElement(new int[] {1, 1, 1, 2, 2, 3}));
        System.out.println(majorityElement2(new int[] {1, 1, 1, 2, 2, 3}));
    }

    static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num) >= nums.length/2) return num;
        }
        return -1;
    }

    static int majorityElement2(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
