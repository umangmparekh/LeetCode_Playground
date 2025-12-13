package C1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, reduce each integer to a single digit using repeated digit-sum,
 * then return the digit that occurs the most. In case of ties, return the largest digit.
 *
 *
 */
public class C1_MostFrequentSingalDigitReading {

    public static void main(String[] arg){

        int[] readings = {123, 456, 789, 7563};
        System.out.println(" max Frequency single digit reading >> "+maxFreqSingleDigitReading(readings));
    }

    public static int maxFreqSingleDigitReading(int[] readings){
        HashMap<Integer, Integer> singleDigitFreqMap = new HashMap<>();
        for(int i : readings){
            int num = singleDigitReading(i);
            singleDigitFreqMap.put(num, singleDigitFreqMap.getOrDefault(i, 0)+1 );
        }

        int bestDigit = -1;
        int maxFreq = 0;
        for(Map.Entry<Integer,Integer> entry : singleDigitFreqMap.entrySet()){
            int digit = entry.getKey();
            int count = entry.getValue();

            while(count > maxFreq || (count == maxFreq && digit > bestDigit)){
                maxFreq = count;
                bestDigit = digit;
            }
        }

        return bestDigit;
    }

    public static int singleDigitReading(int num){

        int singleDigitReading = Math.abs(num);

        while(singleDigitReading >=10){
            int sum =0;
            while(singleDigitReading>0){
                sum += singleDigitReading % 10;
                singleDigitReading /= 10;
            }
            singleDigitReading = sum;
        }

        return singleDigitReading;
    }
}
