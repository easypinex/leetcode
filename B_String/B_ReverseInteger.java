package B_String;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0
 

Constraints:
-231 <= x <= 231 - 1
*/

// 先轉換為String , 在作轉換
public class B_ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(Integer.toString(new B_ReverseInteger().reverse(x)));
    }

    public int reverse(int x) {
        String sX = Integer.toString(x);
        boolean b = false;
        if (sX.startsWith("-")) {
            b = true;
            sX = sX.substring(1);
        }
        String ans = "";
        for (int i = sX.length() - 1; i >= 0; i--) {
            ans += sX.substring(i, i + 1);
        }
        if (b)
            ans = "-" + ans;
        try {
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }
    }
}
