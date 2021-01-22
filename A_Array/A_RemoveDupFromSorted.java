package A_Array;

import java.util.Arrays;

/*
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
... https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727
*/
public class A_RemoveDupFromSorted {
    public static void main(String[] args) {
        int[] sortedArr = { 1, 1, 2, 2, 3 };
        System.out.println(new A_RemoveDupFromSorted().removeDuplicates(sortedArr));
        System.out.println(Arrays.toString(sortedArr));
    }

    public int removeDuplicates(int[] nums) {
        int nonDupIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nonDupIndex]) {
                nonDupIndex++;
                nums[nonDupIndex] = nums[i];
            }
        }
        return nonDupIndex+1;
    }
}