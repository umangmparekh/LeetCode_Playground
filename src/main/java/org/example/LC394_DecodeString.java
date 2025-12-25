package org.example;

import java.util.Stack;

public class LC394_DecodeString {

    public static void main(String[] args) {
        System.out.println(" LC258_AddDigits  >> " + decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String str){
        StringBuilder currentString = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int k =0;
        for(char ch : str.toCharArray()){

            if(Character.isDigit(ch)){
                k = k * 10 + ch - '0';
            } else if(ch == '['){
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k=0;
            } else if(ch == ']'){
                StringBuilder decodedString  = stringStack.pop();
                for(int currentK = countStack.pop(); currentK > 0; currentK--){
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}
