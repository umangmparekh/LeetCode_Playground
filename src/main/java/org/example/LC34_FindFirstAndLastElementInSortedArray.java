package org.example;

import java.util.Arrays;

public class LC34_FindFirstAndLastElementInSortedArray {

    public static void main(String[] args) {

        int[] input = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(" findFirstAndLastElementInSortedArray  >> " + Arrays.toString(findFirstAndLastElementInSortedArray(input, target)));
    }

    public static int[] findFirstAndLastElementInSortedArray(int[] nums, int target) {

        int firstOccurence =  findBound(nums, target, true);

        if(firstOccurence == -1){
            return new int[]{ -1, -1};
        }

        int lastOccurence = findBound(nums, target, false);

        return new int[]{firstOccurence, lastOccurence};
    }

    public static int findBound(int[] nums, int target, boolean isFirst){

        int N = nums.length;
        int begin =0, end= N-1;

        while (begin <= end){
            int mid = (begin + end)/2;

            if(nums[mid] == target){
                if(isFirst){
                    if( mid == begin || nums[mid-1] != target){
                        return mid;
                    }
                    end = mid - 1;
                }else{
                    if(mid == end || nums[mid+1] !=target){
                        return mid;
                    }
                    begin = mid + 1;
                }
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
