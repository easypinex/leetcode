package A_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

// 利用 HashMap 及 HashMap.getOrDefault 的特性解決題目
public class F_IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 8, 4 };
        System.out.println(Arrays.toString(new F_IntersectionOfTwoArraysII().intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> displayCounts = new HashMap<>();
        for (int x : nums1) {
            int count = displayCounts.getOrDefault(x, 0);
            displayCounts.put(x, count + 1);
        }
        List<Integer> crossList = new ArrayList<>();
        for (int y : nums2) {
            int count = displayCounts.getOrDefault(y, 0);
            if (count > 0) {
                displayCounts.put(y, count - 1);
                crossList.add(y);
            }
        }
        int[] crosslist = new int[crossList.size()];
        for (int i = 0; i < crossList.size(); i++) {
            crosslist[i] = crossList.get(i);
        }
        return crosslist;
    }
}