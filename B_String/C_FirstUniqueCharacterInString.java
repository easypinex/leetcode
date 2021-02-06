package B_String;

import java.util.HashSet;

/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

Note: You may assume the string contains only lowercase English letters.
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
*/
// 使用String.charAt(int) 取出 char
public class C_FirstUniqueCharacterInString {

    public static void main(String[] args) {
        System.out.println(new C_FirstUniqueCharacterInString().firstUniqChar("loveleetcode"));
    }
    
    public int firstUniqChar(String s) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0 ; i < s.length() ; i++) {
            char a = s.charAt(i);
            if (hs.contains(a)) continue;
            hs.add(a);
            boolean find = false;
            for (int j = 0 ; j < s.length(); j++) {
                if (j == i)
                    continue;
                if (a == s.charAt(j)) {
                    find = true;
                    break;
                }
            }
            if (!find)
                return i;
        }
        return -1;
    }
}