package DesignQuestions;

import java.util.HashMap;
import java.util.*;

/**
 * *
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 */
class LRUCache_v2 {
    int capacity;
    LinkedHashMap<Integer, Integer> dic;

    public static void main(String arg[]){
        int capacity = 5;
        LRUCache_v2 obj = new LRUCache_v2(capacity);
        int param_1 = obj.get(10);
        obj.put(1,100010);
    }

    public LRUCache_v2(int capacity) {
        this.capacity = capacity;
        dic = new LinkedHashMap<>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(
                    Map.Entry<Integer, Integer> eldest
            ) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return dic.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        dic.put(key, value);
    }
}

