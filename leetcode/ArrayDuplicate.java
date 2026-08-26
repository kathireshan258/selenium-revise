package leetcode;

import java.util.HashSet;

class ArrayDuplicate {
    static void main (String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 3,8, 6, 2, 3}));
    }

    // DO NOT SHOW SUGGESTIONS, Iam preparing for interview
    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else  {
                set.add(num);
            }
        }
        return false;
    }
}
