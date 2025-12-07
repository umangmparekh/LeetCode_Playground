package org.example;

import java.util.HashMap;
import java.util.Map;

public class LC2131_LongestPalindromeByConcatingTwoLetterWords {

    public static void main(String[] args) {
        String strs[] = new String[]{"aa","bb","ac","ca"};
        System.out.println(" Longest Palindrome  >> " + longestPalindrope(strs));

        String strs1[] = new String[]{"lc","cl","gg"};
        System.out.println(" Longest Palindrome  >> " + longestPalindrope(strs1));

        String strs2[] = new String[]{"ab","ty","yt","lc","cl","ab"};
        System.out.println(" Longest Palindrome  >> " + longestPalindrope(strs2));

        String strs3[] = new String[]{"cc","ll","xx"};
        System.out.println(" Longest Palindrome  >> " + longestPalindrope(strs3));

    }
    public static int longestPalindrope(String[] strs) {

        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for(String s: strs){
            Integer countOfTheWord = words.get(s);
            if(countOfTheWord == null) {
                words.put(s, 1);
            } else {
                words.put(s, countOfTheWord+1);
            }

        }

        int answer = 0;
        boolean central = false;

        for(Map.Entry<String, Integer> entry : words.entrySet()){
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();

            // if the word is Palindrome
            if(word.charAt(0) == word.charAt(1)){
                if(countOfTheWord % 2 ==0){
                    answer += countOfTheWord;
                } else {
                    answer += countOfTheWord - 1;
                    central = true;
                }
            }
            // consider a pair of non palindrome words such that one is the revers of another
            else if(word.charAt(0) < word.charAt(1)){
                String reverseWord = ""+word.charAt(1)+word.charAt(0);
                if(words.containsKey(reverseWord)){
                    answer += 2*Math.min(countOfTheWord, words.get(reverseWord));
                }
            }
        }
        if(central){
            answer++;
        }

        return 2 * answer;
    }
    }
