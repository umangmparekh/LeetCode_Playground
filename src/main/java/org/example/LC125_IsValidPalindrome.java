package org.example;

public class LC125_IsValidPalindrome {

    public static void main(String[] args) {

        System.out.println(" isValidPalindrome - A man, a plan, a canal: Panama >> " + isValidPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isValidPalindrome(String str){

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            while(i<j && !Character.isLetterOrDigit(str.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(str.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) return false;
        }


        return true;
    }
}
