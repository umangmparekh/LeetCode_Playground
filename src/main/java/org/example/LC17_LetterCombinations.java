package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 *  LC17 : Letter Combinations of a Phone Number
 *  Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 *
 * 1 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 *
 *
 */
public class LC17_LetterCombinations {
    static StringBuilder sb = new StringBuilder();
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String input = "234";
        System.out.println(" input number >> " + input + " || Letter Combinations >> " + letterCombinations(input));


    }

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        // handle edge case of empty string
        if (digits.isEmpty()) {
            return results;
        }
        // start with adding emptry string
        results.add("");

        //Mapping of digits to corresponding letters
        // index 0 represets digit '2' index 1 represents digit '3'
        String[] digitToLetters = new String[]{
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        for (char digit : digits.toCharArray()) {
            System.out.println(" index >> " + (digit - '2'));
            String letters = digitToLetters[digit - '2'];

            // initialise tempList
            List<String> tempCombinations = new ArrayList<>();

            // for each combinations in result
            for (String existingCombinations : results) {
                for (char letter : letters.toCharArray()) {
                    tempCombinations.add(existingCombinations + letter);
                }
            }
            results = tempCombinations;
        }

        return results;
    }

}