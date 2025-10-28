package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {

    public static void main(String[] args) {
        int[] input1 = {-1,0,1,2,-1,-4};
        System.out.println(" input number >> " + input1 + " || 3Sum Numbers >> " + threeSum(input1));

        int[] input2 = {0,1,1};
        System.out.println(" input number >> " + input2 + " || 3Sum Numbers >> " + threeSum(input2));

        int[] input3 = {0,0,0};
        System.out.println(" input number >> " + input3 + " || 3Sum Numbers >> " + threeSum(input3));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to enable two-pointer technique
        Arrays.sort(nums);

        // Result list to store all unique triplets
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        // Iterate through the array as the first element of triplet
        // Stop at length-2 since we need at least 3 elements
        // Also stop early if current element is positive (sum can't be zero with all positive numbers)
        for(int i=0; i< length-2 && nums[i]<=0; i++){
            // Skip duplicate values for the first element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Two-pointer approach for finding pairs that sum to -nums[i]
            int left = i+1;
            int right = length -1 ;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum<0){
                    // Sum is too small, move left pointer to increase sum
                    left++;
                } else if(sum > 0){
                    // Sum is too large, move right pointer to decrease sum
                    right--;
                } else {
                    // Found a valid triplet with sum equal to zero
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }

            }
        }
        return result;
    }
}
