package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class LC136_SingleNumber {

    public static void main(String[] args) {
        //  int nums[] = new int[]{2,1,-1,-2};
        //  System.out.println(" ArrayOfDoubledPairs  >> " + arrayofDoublePairs(nums));

        int nums1[] = new int[]{2,1,2};
        System.out.println(" LC136_SingleNumber  >> " + singleNumber(nums1));
    }

    public static int singleNumber(int[] nums){
        List<Integer> numsList = new ArrayList<>();

        for(int i : nums){
            if(numsList.contains(i)){
                numsList.remove(Integer.valueOf(i));
            } else {
                numsList.add(i);
            }
        }

        return numsList.get(0);
    }

}
