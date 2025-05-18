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
*/

class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String s = String.valueOf(Math.abs(x));
        StringBuilder y = new StringBuilder();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            y.append(s.charAt(i));
        }

        try {
            int result = Integer.parseInt(y.toString());
            return isNegative ? -result : result;
        } catch (NumberFormatException e) {
            // Handle overflow
            return 0;
        }
    }
}