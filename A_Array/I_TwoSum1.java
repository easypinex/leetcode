package A_Array;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
*/

// HashMap key也可以放值, value 放 Index , 利用此特性解決尋找Index
public class I_TwoSum1 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(new I_TwoSum1().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            hm.put(nums[i], i);
        }
        int other;
        for (int i = 0 ; i < nums.length ; i++) {
            other = target - nums[i];
            if (hm.containsKey(other) && hm.get(other) != i) {
                return new int[] {i, hm.get(other)};
            }
        }
        return new int[2];
    }
}
