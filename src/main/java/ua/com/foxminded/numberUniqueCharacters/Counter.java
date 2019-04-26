package ua.com.foxminded.numberUniqueCharacters;

import java.util.HashMap;
import java.util.Map;

import ua.com.foxminded.cache.Cache;

public class Counter {
    Cache cache = new Cache();
    public HashMap<Character, Integer> countUniqueCharachters(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if (cache.getCache(str) != null) {
            map = cache.getCache(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                Integer frequency = map.get(str.charAt(i));
                map.put(str.charAt(i), frequency == null ? 1 : frequency + 1);
            }
            cache.setCache(str, map);
        }
        return map;
    }
    
    public void print(String str) {
        HashMap<Character, Integer> map = countUniqueCharachters(str);
        System.out.println(str);
        for(Map.Entry<Character, Integer> item : map.entrySet()) {
            System.out.println("\"" + item.getKey() + "\" - " + item.getValue());
        }
    }
}
