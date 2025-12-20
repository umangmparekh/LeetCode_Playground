package org.example;

import java.util.Stack;

/**
 * LeetCode - 146
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 */
public class LC71_SimplifyPath {

    public static void main(String[] args) {

        String path = "/home/user/Documents/../Pictures";
        System.out.println(" LC71_SimplifyPath  >> " + simplifyPath(path));
    }

    public static String simplifyPath(String path){
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for(String directory : components){
            if(directory.equals(".") || directory.isEmpty()){
                continue;
            }
            else if(directory.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }

        StringBuilder result = new StringBuilder();
        for(String dir : stack){
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";

    }
}
