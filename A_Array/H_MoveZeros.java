package A_Array;

import java.util.Arrays;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

// 結合排序紀錄, 與額外空間解決問題
public class H_MoveZeros {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        new H_MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int[] sorted = new int[nums.length];
        int sortI = 0;
        for (int x : nums) {
            if (x != 0) {
                sorted[sortI] = x;
                sortI++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < sortI)
                nums[i] = sorted[i];
            else
                nums[i] = 0;
        }
    }
}
