package ua.com.foxminded.cache;

import java.util.ArrayList;
import java.util.HashMap;

public class Cache {
    private ArrayList<Item> cacheArray = new ArrayList<Item>();
    
    public class Item {
        private String str;
        private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        public void setStr(String str) {
            this.str = str;
        }
        
        public String getStr() {
            return str;
        }
        
        public void setMap(HashMap<Character, Integer> map) {
            this.map = map;
        }
        
        public HashMap<Character, Integer> getMap() {
            return map;
        }
    }
    
    public void setCache(String str, HashMap<Character, Integer> map) {
        Item item = new Item();
        item.setStr(str);
        item.setMap(map);
        cacheArray.add(item);
    }
    
    public HashMap<Character, Integer> getCache(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Item item : cacheArray) {
            if (str.equals(item.getStr())) {
                return item.getMap();
            }
        }
        return null;
    }
    
}
