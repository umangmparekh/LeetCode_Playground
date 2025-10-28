package org.example;

public class LC8_StringToInteger_atoi {

    public static void main(String[] args) {

        String input1 = "42";
        System.out.println(" input number > "+input1+" | StringToInteger >> "+myAtoi(input1));
        String input2 = " -42";
        System.out.println(" input number > "+input2+" | StringToInteger >> "+myAtoi(input2));
        String input3 = "1337c0d3";
        System.out.println(" input number > "+input3+" | StringToInteger >> "+myAtoi(input3));
        String input4 = "0-1";
        System.out.println(" input number > "+input4+" | StringToInteger >> "+myAtoi(input4));
        String input5 = "words and 987";
        System.out.println(" input number > "+input5+" | StringToInteger >> "+myAtoi(input5));

    }
    public static int myAtoi(String s) {
        if(s==null) return 0;
        if(s.isEmpty()) return 0;
        int length = s.length();
        // Skip leading whitespaces
        int index = 0;
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        // Check if string contains only spaces
        if (index == length) return 0;

        // Determine the sign of the number
        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
        }
       // Move past the sign character if present
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }
        // Build the result number
        int result = 0;
        int overflowThreshold = Integer.MAX_VALUE / 10;

        // Process digits
        while (index < length) {
            char currentChar = s.charAt(index);

            // Stop if non-digit character is encountered
            if (currentChar < '0' || currentChar > '9') {
                break;
            }

            // Check for overflow before adding the next digit
            // For positive: result > 214748364 or (result == 214748364 and digit > 7)
            // For negative: result > 214748364 or (result == 214748364 and digit > 8)
            // Since we check with '7', this works for both cases due to sign multiplication
            if (result > overflowThreshold ||
                    (result == overflowThreshold && currentChar > '7')) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to result
            result = result * 10 + (currentChar - '0');
            index++;
        }

        // Apply sign and return final result
        return sign * result;



    }
}
