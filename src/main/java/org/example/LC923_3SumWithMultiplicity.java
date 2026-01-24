package org.example;

public class LC923_3SumWithMultiplicity {

    public static void main(String[] args) {

        int nums1[] = new int[]{0,0,0};
        int target = 0;
        System.out.println(" threeSumMulti V2  >> " + threeSumMulti(nums1, target));
    }

    public static int threeSumMulti(int[] arr, int target) {
        int MOD = (int) 1e9 + 7;

        int[] frequency = new int[101];

        for(int x: arr){
            ++ frequency[x];
        }

        int arrLength = arr.length;
        int tripletCount = 0;

        for(int j=0; j<arrLength; ++j){
            --frequency[arr[j]];
            for(int i=0; i<j; ++i){
                int reqThirdValue  = target - arr[i] - arr[j];

                if(reqThirdValue > 0 && reqThirdValue < frequency.length){
                    tripletCount = (tripletCount + frequency[reqThirdValue]) % MOD;
                }
            }
        }

        return tripletCount;
    }
}
