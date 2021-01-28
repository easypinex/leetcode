package A_Array;

import java.util.Arrays;

/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:
Input: [1,2,3,1]
Output: true

Example 2:
Input: [1,2,3,4]
Output: false

Example 3:
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
/**
 * Arrays.sort排序
 */
public class D_ContainsDuplicate1 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean isDuplicate = new D_ContainsDuplicate().containsDuplicate(nums);
        System.out.println(isDuplicate);
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ; i++) {
            if (i+1 < nums.length && nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}