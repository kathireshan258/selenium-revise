package leetcode;

/**
 * Remove duplicates from a sorted array in-place and return the number of unique elements.
 * (LeetCode 26)
 * */

class RemoveDuplicateFromSortedArray {
    static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1, 1, 1, 2, 2, 3}));
    }

    static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}
