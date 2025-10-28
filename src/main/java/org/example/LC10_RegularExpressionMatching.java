package org.example;

public class LC10_RegularExpressionMatching {

    public static void main(String[] args) {

        String input1 = "aa";
        String p1 = "a";
        System.out.println(" input Str > "+input1+" pattern > "+p1+" | isMatch >> "+isMatch(input1, p1));
        String input2 = "aa";
        String p2 = "a*";
        System.out.println(" input Str > "+input2+" pattern > "+p2+" | isMatch >> "+isMatch(input2, p2));
        String input3 = "ab";
        String p3 = ".*";
        System.out.println(" input Str > "+input3+" pattern > "+p3+" | isMatch >> "+isMatch(input3, p3));

    }

    public static boolean isMatch(String s, String p) {
        return false;
    }
}
