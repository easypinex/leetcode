package A_Array;

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
 * 採用暴力解法... 時間與記憶體用量表現不佳 ...
 */
public class E_SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new E_SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++) {
            boolean dup = false;
            for (int j = 0 ; j < nums.length ; j++) {
                if (j == i) continue;
                if (nums[j] == nums[i]) {
                    dup = true;
                    break;
                }
            }
            if (!dup) return nums[i];
        }
        return -1;
    }

}