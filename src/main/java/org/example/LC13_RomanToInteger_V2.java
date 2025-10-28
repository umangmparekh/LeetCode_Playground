package org.example;

import java.util.HashMap;
import java.util.Map;

public class LC13_RomanToInteger_V2 {

    public static void main(String[] args) {
        String input1 = "III";
        System.out.println(" input Roman >> "+input1+" || Integer Number >> "+romanToInt(input1));

        String input2 = "LVIII";
        System.out.println(" input Roman >> "+input2+" || Integer Number >> "+romanToInt(input2));

        String input3 = "MCMXCIV";
        System.out.println(" input Roman >> "+input3+" || Integer Number >> "+romanToInt(input3));
    }

    public static int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (i < s.length() - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'V') {
                            num += 3;
                            i++;
                        } else if (next == 'X') {
                            num += 8;
                            i++;
                        }
                    }
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if (i < s.length() - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'L') {
                            num += 30;
                            i++;
                        } else if (next == 'C') {
                            num += 80;
                            i++;
                        }
                    }
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if (i < s.length() - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'D') {
                            num += 300;
                            i++;
                        } else if (next == 'M') {
                            num += 800;
                            i++;
                        }
                    }
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
                default:
                    num += 0;
                    break;
            }
        }
        return num;
    }

}
