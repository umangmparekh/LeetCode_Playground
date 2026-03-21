package Intuit;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

    private static HashMap<Character, Character> mappings;
    public static void main(String[] args) {
        mappings = new HashMap<Character, Character>();
        mappings.put('}','{');
        mappings.put(']','[');
        mappings.put(')','(');

        String input1 = "(]";
        System.out.println("Input :-> " + input1 + " |  validParanthesis String >> " + validParanthesis(input1));


    }

    public static boolean validParanthesis(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(mappings.containsKey(c)){
                char topElement = stack.empty() ? '#' : stack.pop();
                if(topElement != mappings.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
