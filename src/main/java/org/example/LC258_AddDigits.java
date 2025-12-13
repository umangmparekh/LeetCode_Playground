package org.example;

import java.util.ArrayList;
import java.util.List;

public class LC258_AddDigits {

    public static void main(String[] args) {
        //  int nums[] = new int[]{2,1,-1,-2};
        //  System.out.println(" ArrayOfDoubledPairs  >> " + arrayofDoublePairs(nums));

        System.out.println(" LC258_AddDigits  >> " + singleNumber(456));
    }

    public static int singleNumber(int num){
        int number = Math.abs(num);

        while(number>=10){
            int sum = 0;
            while(number>0){
                sum += number%10;
                number /= 10;
            }
            number = sum;
        }
       return number;
    }

}
