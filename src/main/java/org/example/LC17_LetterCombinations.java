package org.example;

import java.util.ArrayList;
import java.util.List;

public class LC17_LetterCombinations {
    static StringBuilder sb = new StringBuilder();
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String input ="234";
        System.out.println(" input number >> " + input + " || Letter Combinations >> " + letterCombinations(input));


    }

    public static void backtrack(String[] numString, String digits, int len) {
        if (len == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String cur = numString[digits.charAt(len) - '0'];
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            backtrack(numString, digits, len + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        // handle edge case of empty string
        if (digits == null || digits.length() == 0) {
            return results;
        }
        // start with adding emptry string
        results.add("");

        //Mapping of digits to corresponding letters
        // index 0 represets digit '2' index 1 represents digit '3'
        String[] digitToLetters = new String[]{
                "", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        for(char digit: digits.toCharArray()){
            System.out.println(" index >> "+(digit - '2'));
            String letters = digitToLetters[digit];

            // initialise tempList
            List<String> tempCombinations = new ArrayList<>();

            // for each combinations in result
            for(String existingCombinations : results){
                for(char letter:letters.toCharArray()){
                    tempCombinations.add(existingCombinations+letter);
                }
            }
            results = tempCombinations;
        }

        return results;
    }
}