package A_Array;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

*/

/**
 * 利用額外陣列空間解決問題, 不影響原本陣列空間以利解決問題
 * int[] sortedNums = new int[nums.length];
 */
public class C_RotateArray1 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        new C_RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int[] sortedNums = new int[nums.length];
        int newIndex = -1;
        for(int i = 0 ; i < nums.length ; i++) {
            newIndex = i + k;
            if (newIndex >= nums.length) {
                newIndex = newIndex % nums.length;
            }
            sortedNums[newIndex] = nums[i];
        } 
        for(int i = 0 ; i < sortedNums.length ; i++) {
            nums[i] = sortedNums[i];
        }
    }
}
