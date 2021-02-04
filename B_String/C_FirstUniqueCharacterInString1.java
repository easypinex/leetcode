package B_String;

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

// 利用char可以轉換為int的特性, 算出index , 再計算次數(計算次數也可以用HashMap?)
public class C_FirstUniqueCharacterInString1 {
    public static void main(String[] args) {
        System.out.println(new C_FirstUniqueCharacterInString1().firstUniqChar("loveleetcode"));
    }
    
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {            
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
                
        }
        return -1;
    }
}