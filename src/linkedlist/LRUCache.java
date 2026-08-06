package src.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();//注意这里不能用HashMap
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        Integer value=map.remove(key);
        if (value!=null) {
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.remove(key)!=null) {
            map.put(key,value);
            return;
        }
        if(map.size()==capacity){
            Integer next=map.keySet().iterator().next();
            map.remove(next);
        }
        map.put(key,value);
    }
}
