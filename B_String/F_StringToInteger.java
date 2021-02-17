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

暴力解法, 盡可能考慮極端情況及有可能的輸入, 注意限制條件

利用Integer.MIN_VALUE && Integer.MAX_VALUE 得到 Integer最大最小值 , Character.isDigit(char) 判斷是否為數字
 */
public class F_StringToInteger {

    public int myAtoi(String s) {
        int sI = -1, eI = -1;
        char t;
        boolean isNev = false;
        boolean nevFlag = false;
        int nevI = -1;
        for (int i = 0; i < s.length(); i++) {
            t = s.charAt(i);
            if (t == ' ')
                continue;
            if (Character.isLetter(t) || t == '.') {
                break;
            }
            if (t == '-' || t == '+') {
                if (nevFlag) {
                    break;
                }
                if (t == '-')
                    isNev = !isNev;
                nevFlag = true;
                nevI = i;
            }

            if (Character.isDigit(t)) {
                if (nevI != -1 && nevI + 1 != i)
                    break;
                sI = i;
                eI = i + 1;
                break;
            }
        }
        if (sI != -1) {
            for (int i = sI; i < s.length(); i++) {
                t = s.charAt(i);
                if (t == '.') {
                    eI = i;
                    break;
                }
                if (Character.isDigit(t)) {
                    eI = i + 1;
                } else {
                    break;
                }
            }
        }

        if (sI == -1 || eI == -1) {
            return 0;
        }
        s = s.substring(sI, eI);
        if (isNev)
            s = "-" + s;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            if (isNev) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}