package org.example;

public class LC9_PalindromeNumber {

    public static void main(String[] args) {

        int input1 = 12121;
        System.out.println(" input number "+input1+" isPalindrome Number "+isPalindrome(input1));
        int input2 = -121;
        System.out.println(" input number "+input2+" isPalindrome Number "+isPalindrome(input2));
        int input3 = 10;
        System.out.println(" input number "+input3+" isPalindrome Number "+isPalindrome(input3));
        int input4 = 5;
        System.out.println(" input number "+input4+" isPalindrome Number "+isPalindrome(input4));
        int input5 = 100;
        System.out.println(" input number "+input5+" isPalindrome Number "+isPalindrome(input5));

    }
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        // Reverse half of the number
        int reversedHalf = 0;
        while (reversedHalf < x) {
            // Extract the last digit of x and append it to reversedHalf
            reversedHalf = reversedHalf * 10 + x % 10;
            // Remove the last digit from x
            x /= 10;

            System.out.println(" x > "+x+" reversedHalf > "+reversedHalf);
        }
        // For even length numbers: x == reversedHalf
        // For odd length numbers: x == reversedHalf / 10 (ignore the middle digit)
        System.out.println("x == reversedHalf"+(x == reversedHalf)+" x == reversedHalf / 10 "+(x == reversedHalf / 10));
        return x == reversedHalf || x == reversedHalf / 10;

    }
}
