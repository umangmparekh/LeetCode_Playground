package org.example;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class LC7_ReverseInteger {
    public static void main(String[] args) {

        int input1 = 123;
        System.out.println(" input number "+input1+" Reverse Number "+reverse(input1));
        int input2 = -124;
        System.out.println(" input number "+input2+" Reverse Number "+reverse(input2));
        int input3 = 1200;
        System.out.println(" input number "+input3+" Reverse Number "+reverse(input3));

    }
    public static int reverse(int x) {

        int reversedNumber = 0;

        while (x!=0){

            if(reversedNumber > Integer.MAX_VALUE/10 || reversedNumber < Integer.MIN_VALUE/10 ){
                return 0;
            }

            // extract last digit & add it to reversed number
            int lastDigit = x % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;

            // remove last digit
            x = x / 10;
        }
        return reversedNumber;
    }

}
