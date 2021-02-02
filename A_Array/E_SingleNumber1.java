package A_Array;

import java.util.HashSet;

/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?


Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

*/

/**
 * 利用 HashSet 新增會回傳成功與失敗的特性, 完成題目
 */
public class E_SingleNumber1 {

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(new E_SingleNumber1().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) {
            if (!hs.add(x))
                hs.remove(x);
        }
        for (int x : hs) {
            return x;
        }
        return -1;
    }

}