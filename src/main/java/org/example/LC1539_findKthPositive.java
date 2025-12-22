package org.example;

public class LC1539_findKthPositive {

    public static void main(String[] args) {
        //  int nums[] = new int[]{2,1,-1,-2};
        //  System.out.println(" ArrayOfDoubledPairs  >> " + arrayofDoublePairs(nums));

        int nums1[] = new int[]{2,3,4,7,11};
        int k =5;
        System.out.println(" LC1539_findKthPositive  >> " + findKthPositive(nums1, k));
    }

    public static int findKthPositive(int[] nums, int k){
        for(int num : nums){
            if(num <= k){
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
