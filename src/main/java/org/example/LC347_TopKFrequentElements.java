package org.example;

import java.util.*;

public class LC347_TopKFrequentElements {
    public static void main(String[] args) {
         int nums[] = new int[]{1,2,1,2,1,2,3,1,3,2};
         int topK = 2;
        System.out.println(" LC347_TopKFrequentElements  >> " + Arrays.toString(topKFrequentElements(nums, topK)) );
    }

    public static int[] topKFrequentElements(int[] nums, int topK){
        // O(1)
        if(nums.length == topK){
            return nums;
        }
        // Build HashMap character and how often it appears
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        // initiate Heap to create 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        for( int n: count.keySet()){
            heap.add(n);
            if(n > topK){
                heap.poll();
            }
        }

        // now initiate the result array
        int[] result = new int[topK];
        for (int i=topK-1; i>=0; --i){
            result[i] = heap.poll();
        }

        return result;
    }
}
