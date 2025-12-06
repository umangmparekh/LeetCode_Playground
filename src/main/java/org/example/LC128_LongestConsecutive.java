package org.example;

import java.util.HashSet;
import java.util.Set;

public class LC128_LongestConsecutive {

    public static void main(String[] args) {
        int nums[] = new int[]{100,4,200,1,3,2};
        System.out.println(" Longest consecutive >> "+longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num: nums){
            num_set.add(num);
        }

        int longestStreak = 0;

        for(int num: num_set){
            System.out.println(" num "+num);
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(num_set.contains(currentNum+1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max( longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

}
