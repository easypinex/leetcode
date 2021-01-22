package A_Array;

import java.util.Arrays;

/**
 * 1-Remove
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