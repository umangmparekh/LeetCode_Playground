package Intuit;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {


        int[] digits = {9,9};
        System.out.println("Input :-> " + Arrays.toString(digits) + " |  validParanthesis String >> " + Arrays.toString(plusOne(digits)));

    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int idx = n-1;idx >=0; --idx){
            if(digits[idx] == 9){
                digits[idx] = 0;
            } else {
                digits[idx]++;
                return digits;
            }
        }
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}
