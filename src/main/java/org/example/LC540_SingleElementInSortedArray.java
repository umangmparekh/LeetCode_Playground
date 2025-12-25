package org.example;

public class LC540_SingleElementInSortedArray {

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(" singleElementInSortedArray  >> " + singleElementInSortedArray(nums));

        int nums1[] = new int[]{3,3,7,7,10,11,11};
        System.out.println(" singleElementInSortedArray  >> " + singleElementInSortedArray(nums1));
    }

    public static int singleElementInSortedArray(int[] nums){
        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi){
            int mid = lo + (hi -lo)/2;
            boolean halvesAreEven = (hi - mid) %2 == 0;
            if(nums[mid] == nums[mid+1]){
                if(halvesAreEven){
                    lo = mid + 2;
                }else {
                    hi = mid - 1;
                }
            }else if(nums[mid] == nums[mid-1]){
                if(halvesAreEven){
                    hi = mid - 2;
                }else {
                    lo = mid +1;
                }
            }else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
}
