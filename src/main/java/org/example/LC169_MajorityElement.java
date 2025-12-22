package org.example;

public class LC169_MajorityElement {

    public static void main(String[] args) {
        int nums1[] = new int[]{2,1,2, 2, 5, 5, 5,5, 5};
        System.out.println(" LC169_MajorityElement  >> " + majorityElement(nums1));
    }

    public static int majorityElement(int[] nums){

        int majorityCount =  nums.length / 2;

        for(int num : nums){
            int count = 0;
            for(int element : nums){
                if(num == element){
                    count +=1;
                }
            }

            if(count > majorityCount){
                return num;
            }
        }
        return -1;
    }
}
