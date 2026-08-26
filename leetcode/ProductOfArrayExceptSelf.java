package leetcode;

/**
 * Product of Array Except Self (LeetCode 238)
 * Question:
 * Given an integer array nums, return an array answer such that:
 *
 answer[i]
 =
 product of all elements of nums
 except nums[i]
 You must solve it without using division.

 Example1:
 Input:
 nums = [1,2,3,4]

 Output:
 [24,12,8,6]

 Why?
 For index 0:
 2 × 3 × 4 = 24
 For index 1:
 1 × 3 × 4 = 12
 For index 2:
 1 × 2 × 4 = 8
 For index 3:
 1 × 2 × 3 = 6
 Result:
 [24,12,8,6]

 Example2:
 Input:
 nums = [-1,1,0,-3,3]

 Output:
 [0,0,9,0,0]
 * */

import java.util.Arrays;

class ProductOfArrayExceptSelf {
    static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4,5})));
    }

    static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;

        // calculate left product
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        System.out.printf("Left Product %s%n", Arrays.toString(answer));

        // calculate right product at run time and store final answer in answer[]
        int rightProduct = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        System.out.printf("Final product %s%n", Arrays.toString(answer));
        return answer;
    }
}
