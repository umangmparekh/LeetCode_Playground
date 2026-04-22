package crowdstrike;

import java.util.*;

public class TopKElements {

    public static int[] topKElements(int[] nums, int k){

        // Step 1: frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.merge(i, 1, Integer::sum);
        }

        // Step 2 : bucket[i] = list of numbers that appears i times
        // Max possible frequency in nums.length

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int num : freq.keySet()){
            int f =  freq.get(num);
            if(buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(num);
        }

        // Step 3 : collect top K by scanning buckets high > low
        int[] result = new int[k];
        int idx= 0;
        for(int f = buckets.length - 1; f >= 1 && idx < k; f--){
            if(buckets[f] != null){
                for(int num : buckets[f]){
                    result[idx++] = num;
                    if(idx == k) break;
                }

            }
        }

        return result;
    }

    public static void main(String[] args){

        System.out.println(Arrays.toString(topKElements(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(topKElements(new int[]{1}, 1)));
        System.out.println(Arrays.toString(topKElements(new int[]{4,4,4,6,6,7,7,7,7,9}, 2)));

    }
}
