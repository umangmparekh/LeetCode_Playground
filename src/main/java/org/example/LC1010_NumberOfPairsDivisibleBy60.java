package org.example;

public class LC1010_NumberOfPairsDivisibleBy60 {

    public static void main(String[] args) {
        int nums[] = new int[]{30,20,150,100,40};
        System.out.println(" Number of Pairs divisible by 60  >> " + numberOfPairsDivisibleBy60(nums));

    }

    public static int numberOfPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count=0;
        for(int t: time){
            if(t%60 == 0) {
                count += remainders[0];
            } else {
                count += remainders[60-t%60];
            }
            remainders[t%60]++;
        }
        return count;

    }
}