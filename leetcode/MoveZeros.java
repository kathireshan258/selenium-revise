package leetcode;

import java.util.Arrays;

public class MoveZeros {
    static void main (String[] args) {
        int[] arr = new int[] {0,1,0,3,0,5};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveZeros(int[] nums) {
        int write = 0;
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }
        }

        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }
}
