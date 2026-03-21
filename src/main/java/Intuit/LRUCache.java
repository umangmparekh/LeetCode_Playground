package Intuit;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> dic;

    public LRUCache(int capacity){
        this.capacity = capacity;
        dic = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removedEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > capacity;
            }
        };
    }

    public int get(int key){
        return dic.getOrDefault(key, -1);
    }

    public void put(int key, int value){
        dic.put(key, value);
    }
}
