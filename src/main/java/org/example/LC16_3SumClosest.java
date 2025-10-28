package org.example;

import java.util.Arrays;

public class LC16_3SumClosest {

    public static void main(String[] args) {
        int target =1;
        int[] input1 = {-1,2,1,-4};
        System.out.println(" input number >> " + input1 + " || 3SumClosest Number >> " + threeSumClosest(input1, target));

        int[] input2 = {0,1,0};
        System.out.println(" input number >> " + input2 + " || 3SumClosest Number >> " + threeSumClosest(input2,  target));

    }
    public static int threeSumClosest(int[] nums, int target) {
        // sort the array
        Arrays.sort(nums);

        //initialise closestSum with large value
        int closestSum = 1 << 30;
        System.out.println("init closestSum "+ closestSum );
        int aLength = nums.length;

        // fix first number and find next two numbers with two pointers
        for(int i=0; i<aLength; ++i){
            // initilise two pointers
            int left = i+1;
            int right  = aLength-1;

            // Use the two pointers technique to find the closest sum
            while(left<right){

                int currentSum = nums[i]+nums[left]+nums[right];

                if(currentSum == target){
                    return currentSum;
                }

                if(Math.abs(currentSum-target) < Math.abs(closestSum-target)){
                    closestSum = currentSum;
                }

                // Move pointers based on the comparision with Target value
                if(currentSum>target){
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return closestSum;
    }

}
