package org.example;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/array-of-doubled-pairs/
 *
 * Complexity Analysis
 *
 * Time Complexity: O(NlogN), where N is the length of A.
 *
 * Space Complexity: O(N).
 *
 */
public class LC954_ArrayOfDoubledPairs {

    public static void main(String[] args) {
      //  int nums[] = new int[]{2,1,-1,-2};
      //  System.out.println(" ArrayOfDoubledPairs  >> " + arrayofDoublePairs(nums));

        int nums1[] = new int[]{2,1,-1,-2};
        System.out.println(" ArrayOfDoubledPairs V2  >> " + arrayofDoublePairsV2(nums1));
    }

    public static boolean arrayofDoublePairs(int[] arr) {

        Map<Integer, Integer> arrayCount = new HashMap<>();
        for(int x : arr ){
            arrayCount.put(x, arrayCount.getOrDefault(x, 0)+1);
        }

        Integer[] B = new Integer[arr.length];
        for(int i=0;i<arr.length; ++i){
            B[i] = arr[i];
        }
        Arrays.sort(B, Comparator.comparingInt(Math :: abs));

        for(int x:B){
            if(arrayCount.get(x) == 0) continue;

            if(arrayCount.getOrDefault(2*x, 0) <= 0) return false;

            // Write x, 2*x
            arrayCount.put(x, arrayCount.get(x) -1);
            arrayCount.put(2*x, arrayCount.get(2*x)-1);
        }

        return true;
    }

    public static boolean arrayofDoublePairsV2(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (l1, l2) -> (Math.abs(l1) - Math.abs(l2)));

        for (int num : list) {
            int count = map.get(num);
            if (count == 0) {
                continue;
            }

            int pairCount = map.getOrDefault(2 * num, 0);
            if (count > pairCount) {
                return false;
            }
            map.put(2 * num, pairCount - count);
        }
        return true;
    }
}
