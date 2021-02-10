package B_String;

/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

Constraints:

s consists only of printable ASCII characters.
 */

 // 利用 Character.toLowerCase(char) 讓char變小寫
public class E_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int sE = s.length()-1;
        for (int i = 0 ; i < s.length() ; i++) {
            if ( i >= sE) return true;
            if (!isAlphanumeric(s.charAt(i))) {
                continue;
            }
            while (!isAlphanumeric(s.charAt(sE))) {
                sE--;
            }
            if (Character.toLowerCase(s.charAt(sE)) != Character.toLowerCase(s.charAt(i))) {
                return false;
            }
            sE--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char s) {
        return (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z') || (s>= '0' && s <= '9');
    }
}