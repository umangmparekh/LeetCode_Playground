package org.example;

import java.util.Arrays;

public class LC14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] input1 = {"flower", "flow", "floight"};
        System.out.println(" input number >> "+ Arrays.stream(input1).toList()+" || longestCommonPrefix >> "+longestCommonPrefix(input1));

        String[] input2 = {"dog","racecar","car"};
        System.out.println(" input number >> "+ Arrays.stream(input2).toList()+" || longestCommonPrefix >> "+longestCommonPrefix(input2));
    }
    public static String longestCommonPrefix(String[] strs) {
        int numOfStrings = strs.length;

        for(int charIndex=0; charIndex< strs[0].length(); charIndex++){
            for(int stringIndex=1; stringIndex <numOfStrings; stringIndex++){

                if(strs[stringIndex].length()<=charIndex ||
                strs[stringIndex].charAt(charIndex) != strs[0].charAt(charIndex)){
                    return strs[0].substring(0, charIndex);
                }

            }
        }

        return strs[0];
    }
}