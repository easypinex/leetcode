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

// 利用StringBuilder reverse反轉 及 Math.abs 取絕對值 解決
// NumberFormatException 常見Exception .
public class B_ReverseInteger1 {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(Integer.toString(new B_ReverseInteger1().reverse(x)));
    }

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder().append(Math.abs(x));
        sb.reverse();
        int a;
        try {
            a = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        if (x < 0)
            a = a * -1;
        return a;
    }
}
