package org.example;

import java.util.HashMap;
import java.util.Map;

public class LC13_RomanToInteger {

    public static void main(String[] args) {
        String input1 = "III";
        System.out.println(" input Roman >> "+input1+" || Integer Number >> "+romanToInt(input1));

        String input2 = "LVIII";
        System.out.println(" input Roman >> "+input2+" || Integer Number >> "+romanToInt(input2));

        String input3 = "MCMXCIV";
        System.out.println(" input Roman >> "+input3+" || Integer Number >> "+romanToInt(input3));

    }

    public static int romanToInt(String s) {
        // Define Roman numeral characters and their corresponding values
        String romanChars = "IVXLCDM";
        int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};

        Map<Character, Integer> romanToValueMap = new HashMap<>();
        for (int i = 0; i < romanValues.length; i++) {
            romanToValueMap.put(romanChars.charAt(i), romanValues[i]);
        }
        // Get the length of the input string
        int length = s.length();
        // Initialize result with the value of the last character
        // (Last character is always added, never subtracted)
        int result = romanToValueMap.get(s.charAt(length - 1));

        // Process each character from left to right (except the last one)
        for (int i = 0; i < length - 1; i++) {
            // If current character's value is less than the next character's value,
            // subtract it (e.g., IV = 4, IX = 9)
            // Otherwise, add it to the result
            int sign = romanToValueMap.get(s.charAt(i)) < romanToValueMap.get(s.charAt(i + 1)) ? -1 : 1;
            System.out.println(" sign "+sign+" || "+romanToValueMap.get(s.charAt(i)));
            result += sign * romanToValueMap.get(s.charAt(i));
        }



        return result;
    }

}
