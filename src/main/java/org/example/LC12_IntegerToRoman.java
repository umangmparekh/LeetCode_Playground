package org.example;

import java.util.List;
public class LC12_IntegerToRoman {
    public static void main(String[] args) {
        int input1 = 10;
        System.out.println(" input number >> "+input1+" || Roman Number >> "+intToRoman(input1));

        int input2 = 94;
        System.out.println(" input number >> "+input2+" || Roman Number >> "+intToRoman(input2));
    }
    public static String intToRoman(int num) {
        // Define Roman numeral symbols in descending order of value
        // Include subtractive notation pairs (CM, CD, XC, XL, IX, IV)
        List<String> romanSymbols = List.of(
                "M",   // 1000
                "CM",  // 900
                "D",   // 500
                "CD",  // 400
                "C",   // 100
                "XC",  // 90
                "L",   // 50
                "XL",  // 40
                "X",   // 10
                "IX",  // 9
                "V",   // 5
                "IV",  // 4
                "I"    // 1
        );

        // Corresponding integer values for each Roman symbol
        List<Integer> values = List.of(
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        );

        // StringBuilder for efficient string concatenation
        StringBuilder result = new StringBuilder();
        // Iterate through each Roman symbol-value pair
        for (int i = 0; i < romanSymbols.size(); i++) {
            // Repeatedly subtract the current value while possible
            // and append the corresponding Roman symbol
            while (num >= values.get(i)) {
                num -= values.get(i);
                result.append(romanSymbols.get(i));
            }
        }

        return result.toString();

    }
}
