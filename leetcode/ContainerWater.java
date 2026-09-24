package leetcode;

/**
 * Two pointer problem:
 * Problem: Container With Most Water
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the iᵗʰ line are:
 * (i, 0) and (i, height[i])
 * Find two lines that together with the x-axis form a container such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * You may not slant the container.

 * Input:
 * height = integer array
 *Output:
 * Maximum amount of water that can be contained.

 * Example 1:
 * Input:
 * height = [1,8,6,2,5,4,8,3,7]
 * Output:
 * 49
 * Explanation:
 * Choose:
 * height[1] = 8
 * height[8] = 7
 * Width:
 * 8 - 1 = 7
 * Height of container:
 * min(8, 7) = 7
 * Water stored:
 * 7 × 7 = 49

 * Example 2:
 * Input:
 * height = [1,1]
 * Output:
 * 1

 * Constraints:
 * 2 <= height.length <= 100000
 * 0 <= height[i] <= 10000

 * Guarantees:
 * Heights are non-negative.
 * Need the maximum possible water.
 * Need only the maximum area, not the indices.
 * */

class ContainerWater {
    static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max area the container can store: " + maxArea(height));
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int containerHeight = Math.max(height[left], height[right]);
            int area = width * containerHeight;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else if (height[left] == height[right]) {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
