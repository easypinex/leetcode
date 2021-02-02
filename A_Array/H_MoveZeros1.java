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

// 紀錄已排序的位置(可以排序後再紀錄)
public class H_MoveZeros1 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        new H_MoveZeros1().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int firstZero = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && firstZero < 0) {
                firstZero = i;
            }
            if(nums[i] != 0 && firstZero >= 0 && firstZero < i) {
                nums[firstZero] = nums[i];
                nums[i] = 0;
                firstZero++;
                while(firstZero < nums.length && nums[firstZero] != 0) {
                    firstZero++;
                }
            }
        }
    }
}
