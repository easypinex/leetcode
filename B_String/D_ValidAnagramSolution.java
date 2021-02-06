package B_String;

import java.util.HashMap;

/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
// Map.ketSet() 輪詢取出 key 值
public class D_ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = countChar(s);
        HashMap<Character, Integer> tMap = countChar(t);
        for (char key :sMap.keySet()) {
            int count = sMap.get(key);
            int tCount = tMap.getOrDefault(key, 0);
            tCount -= count;
            if (tCount != 0) {
                return false;
            }
            tMap.put(key, tCount);
        }
        for (char key : tMap.keySet()) {
            if (tMap.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public HashMap<Character, Integer> countChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char c;
        int count;
        for (int i = 0 ; i < s.length(); i++) {
            c = s.charAt(i);
            count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }
        return map;
    }
}