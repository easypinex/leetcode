package B_String;

/*
F_StringToInteger

Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.


Constraints:
0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

參考他人寫法, 利用 /10 特性, 記住之前之後, 以及 越早數字 *10 , 保值新的值是個位數
 */
public class F_StringToInteger1 {

    public int myAtoi(String s) {
        int number = 0, index = 0, length = s.length(), value;
        boolean isNegative = false;

        // 前面空白刪除
        while (index < length && s.charAt(index) == ' ')
            index++;
        // 第一位正負數判斷
        if (index < length && s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (index < length && s.charAt(index) == '+')
            index++;
        // 確認為數字
        while (index < length && Character.isDigit(s.charAt(index))) {
            value = number; // 記住原本的直
            // 越早得到的數 會一直 * 10 ... 讓後得到的數確保為個位
            number = number * 10 + s.charAt(index) - '0';
            if (number / 10 != value) // 確保 / 10 後為原本的值
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            index++;
        }

        return isNegative ? number * -1 : number;
    }
}