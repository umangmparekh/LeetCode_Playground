package org.example;

public class LC400_FindNthDigit {

    public static void main(String[] args) {

        System.out.println(" LC400_FindNthDigit  >> " + findNthDigit(450));
    }

    public static int findNthDigit(int n) {
        long digitLength = 1;
        long count = 9;
        long start = 1;

        while (n> digitLength * count){
            n -= digitLength* count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        start += (n-1)/digitLength;

        String number = Long.toString(start);
        return number.charAt((int) ((n - 1) % digitLength)) - '0';

    }
}