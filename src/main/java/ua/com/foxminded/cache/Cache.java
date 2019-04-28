package ua.com.foxminded.cache;

import java.util.HashMap;

public class Cache {
    HashMap<String, HashMap<Character, Integer>> cache = new HashMap<String, HashMap<Character, Integer>>();
    
    public void setCache(String str, HashMap<Character, Integer> map) {
        cache.put(str, map);
    }
    
    public HashMap<Character, Integer> getCache(String str) {
        return cache.get(str);
    }   
}
