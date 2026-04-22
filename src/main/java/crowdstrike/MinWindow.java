package crowdstrike;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public static String minWindow(String s, String t){
        if(s.isEmpty() || t.isEmpty() ) throw new IllegalArgumentException("EmptyStrings");

        // Frequency map for Chars we need from String t
        Map<Character, Integer> need = new HashMap<>();
        for(char c: t.toCharArray()){
            need.merge(c, 1, Integer::sum);
        }

        int required = need.size(); // distinct chars in t that must be satisfied
        int formed =0;

        Map<Character, Integer> window = new HashMap<>();
        int left =0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for(int right=0; right < s.length(); right++){
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            // Check if this char's frequency now satisfies t's requirement
            if(need.containsKey(c) && window.get(c).equals(need.get(c))){
                formed++;
            }

            // Shrink from left while window is valid
            while(formed == required && left <= right){
                // Record minimum window
                if(right - left + 1 < minLen){
                    minLen = right - left +1;
                    minLeft = left;
                }

                // Remove s[left] from window and shrink
                char leftChar = s.charAt(left);
                window.merge(leftChar, -1, Integer::sum);
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    formed--;
                }

                left++;
            }
        }


        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft+minLen);


    }

    public static void main(String[] args) {
        // Example 1: n=10, m=3  → [4, 3, 3]
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

        System.out.println(minWindow("a", "a"));

        System.out.println(minWindow("a", "aab"));

    }
}
