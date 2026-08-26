package leetcode;

/**
 * Problem: Intersection of Two Arrays
 * Problem Statement:
 * Given two integer arrays nums1 and nums2, return an array of their **intersection**.
 * Each element in the result must be **unique**, and you may return the result in any order.
 * Input:
 * nums1 = integer array
 * nums2 = integer array
 * Output:
 * An array containing unique common elements.
 *
 * Example 1:
 * nums1: [1,2,2,1]
 * nums2: [2,2]
 * Output:
 * [2]
 *
 * Example2:
 * Input:
 * nums1 = [4,9,5]
 * nums2 = [9,4,9,8,4]
 * Output:
 * [4,9]
 * or
 * [9,4]
 *
 * Example 3:
 * Input:
 * nums1 = [1,2,3]
 * nums2 = [4,5,6]
 * output:
 * []
 *
 * Important Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * Important Guarantee:
 * The result must contain **unique elements only**.
 * Example:
 * nums1 = [2,2,2]
 * nums2 = [2,2]
 * Output:
 * [2]
 * Not:
 * [2,2]
 *
 * Note:
 * Constraints tell us the limits of the input.
 * They help us answer:
 * How large can the input be?
 * and
 * Which algorithm is acceptable?
 * */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

class ArrayIntersection {
    static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {4, 5, 6, 7, 8};
        System.out.printf("Intersecting array: %s%n", Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> presentInNum2 = new HashSet<>();
        for(int num2: nums2) {
            presentInNum2.add(num2);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int num1: nums1) {
            if(presentInNum2.contains(num1)) {
                result.add(num1);
                presentInNum2.remove(num1);
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
