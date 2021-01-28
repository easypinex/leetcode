package A_Array;

import java.util.HashSet;
import java.util.Set;

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
 * HashSet比對速度比ArrayList快許多
 */
public class D_ContainsDuplicate2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean isDuplicate = new D_ContainsDuplicate().containsDuplicate(nums);
        System.out.println(isDuplicate);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int x : nums) {
            if (numSet.contains(x)) return true;
            numSet.add(x);
        }
        return false;
    }
}