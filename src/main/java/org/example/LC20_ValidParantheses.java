package org.example;

import java.util.HashMap;
import java.util.Stack;

public class LC20_ValidParantheses {

    private HashMap<Character, Character> mappings;

    public LC20_ValidParantheses(){
        this.mappings = new HashMap<>();

        this.mappings.put(')','(');
        this.mappings.put('}', '{');
        this.mappings.put(']','[');

    }
    public static void main(String[] args) {
        LC20_ValidParantheses prog = new LC20_ValidParantheses();
        System.out.println(" LC20_ValidParantheses  >> " + prog.validParantheses("()[]{}"));
    }

    public Boolean validParantheses(String s){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(this.mappings.containsKey(c)){
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if(topElement != this.mappings.get(c)){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
