package leetcode;

/**
 * Problem: Next Greater Element I
 * Interview question:
 * Given two integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each element in nums1, find the next greater element in nums2.
 * The next greater element of a number x is the first greater number that appears to its right in nums2.
 * If no such element exists, return -1.
 * Input:
 * nums1 = [4,1,2]
 * nums2 = [1,3,4,2]

 * Output:
 * [-1,3,-1]

 * Example 1
 * Input:
 *nums1 = [4,1,2]
 nums2 = [1,3,4,2]
 Output:
 [-1,3,-1]

 Explanation:
 4 -> no greater element on right -> -1
 1 -> first greater element on right is 3
 2 -> no greater element on right -> -1

 Example 2
 Input:
 nums1 = [2,4]
 nums2 = [1,2,3,4]

 Output:
 [3,-1]
 [3,-1]

 Explanation:
 2 -> next greater is 3
 4 -> nothing greater on right -> -1

 Constraints:
 1 <= nums1.length <= nums2.length <= 1000
 0 <= nums1[i], nums2[i] <= 10^4
 All integers in nums1 and nums2 are unique.
 nums1 is a subset of nums2.

 Guarantees:
 All values are unique.
 nums1 elements always exist in nums2.
 * */

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

class NextGreaterElementI {
    static void main (String[] args) {
        int[] nums1 = {8,7,9,10};
        int[] nums2 = {8,7,9,6,10};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] nextGreaterElement (int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<> ();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int removedVal = stack.pop();
                System.out.println(removedVal + " removed from stack");
            }

            int nextGreaterVal = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], nextGreaterVal);
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    private static int[] nextGreatEle(int[] nums1, int[] num2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = num2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && num2[i] > stack.peek()) {
                stack.pop();
            }
            int nextGreaterVal = stack.isEmpty() ? -1 : stack.peek();
            map.put(num2[i], nextGreaterVal);
            stack.push(num2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

}
