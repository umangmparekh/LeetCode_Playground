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
public class LC17_LetterCombinations_v2 {
    static StringBuilder sb = new StringBuilder();
    static List<String> res = new ArrayList<>();

    private static final String[] MAP = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        String input = "234";
        System.out.println(" input number >> " + input + " || Letter Combinations >> " + letterCombinations(input));


    }

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private static void backtrack(String digits, int idx, StringBuilder path, List<String> res) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }

        String letters = MAP[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(digits, idx + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}