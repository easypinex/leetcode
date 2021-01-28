package A_Array;

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
 * 原生比對超時...
 */
public class D_ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean isDuplicate = new D_ContainsDuplicate().containsDuplicate(nums);
        System.out.println(isDuplicate);
    }

    public boolean containsDuplicate(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++) {
            for (int j = i+1 ; j < nums.length ; j++) {
                if (j >= nums.length ) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}