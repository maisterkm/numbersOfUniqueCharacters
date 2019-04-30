package ua.com.foxminded.numberUniqueCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Counter {
    private HashMap<String, HashMap<Character, Integer>> cache = new HashMap<String, HashMap<Character, Integer>>();
    private HashMap<Character, Integer> globalMap = new HashMap<Character, Integer>();
    private ArrayList<String> arrOfSequences = new ArrayList<String>();
    
//    1) the number of unique characters in the current line
    public HashMap<Character, Integer> countUniqueCharachters(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if (getCache(str) != null) {
            map = getCache(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                Integer frequency = map.get(str.charAt(i));
                map.put(str.charAt(i), frequency == null ? 1 : frequency + 1);
            }
            setCache(str, map);
        }
        return map;
    }
    
//    2) how many times the particular character appears in the global text
    public void printFrequencyFromGlobalMap() {
        System.out.println("The number of unique characters in the global text");
        for(Map.Entry<Character,Integer> item : globalMap.entrySet()) {
            System.out.println("\"" + item.getKey() + "\" - " + item.getValue());
        }
    }
    
    public void addStringToGlobalMap(String str) {
            if (getCache(str) != null) {
                globalMap = getCache(str);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    Integer frequency = globalMap.get(str.charAt(i));
                    globalMap.put(str.charAt(i), frequency == null ? 1 : frequency + 1);
                }
                setCache(str, countUniqueCharachters(str));
            }
    }
    
//    3) how many vowels and consonants in the current line
    public void countCharacterType(String str) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
                if (isConsonant(str.charAt(i))) {
                    consonants++;
                } else if(isVowel(str.charAt(i))) {
                    vowels++;
                }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonant: " + consonants);
    }
    
//    4) how many continuous consonant sequences in the line
    public int countConsonantSequences(String str) {
        String consonantSequence = "";
        arrOfSequences.clear();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (isConsonant(str.charAt(j))) {
                    consonantSequence += str.charAt(j);
                } else {
                    break;
                }
                i = j;
            }
            if (consonantSequence.length() >= 2) {
                arrOfSequences.add(consonantSequence);
            }
            consonantSequence = "";
        }
        return arrOfSequences.size();
    }
    
//    5) for each symbol the minimal and maximal index of it in the line
    public void printMinMaxIndexForSymbol(String str) {
        Integer min;
        Integer max;
        HashMap<Character, Integer> minMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> maxMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < str.length(); i++) {
            min  = minMap.get(str.charAt(i));
            if (min == null) {
                minMap.put(str.charAt(i), i);
            }
            max = maxMap.get(str.charAt(i));
            maxMap.put(str.charAt(i), max == null ? i : i);
        }
        Iterator<Map.Entry<Character, Integer>> itMin = minMap.entrySet().iterator();
        Iterator<Map.Entry<Character, Integer>> itMax = maxMap.entrySet().iterator();
        while (itMax.hasNext() && itMin.hasNext()) {
            Map.Entry<Character, Integer> entryMin = (Map.Entry<Character, Integer>)itMin.next();
            Map.Entry<Character, Integer> entryMax = (Map.Entry<Character, Integer>)itMax.next();
            System.out.println("For symbol '" + entryMin.getKey() + "' minimal index is " + entryMin.getValue() + 
                                ", maximal index is " + entryMax.getValue());
        }
    }
    
    public void printContinuousConsonantSequences() {
        for (String item : arrOfSequences) {
            System.out.println(item);
        }
    }
    
    private boolean isVowel(Character chr) {
        if ((chr >= 'a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z')) {
            chr = Character.toLowerCase(chr);
            if (chr == 'a' && chr == 'e' && chr == 'i' && chr == 'o' && chr == 'u') {
                return true;
            }
        }
        return false;
    }
    
    private boolean isConsonant(Character chr) {
        if ((chr >= 'a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z')) {
            chr = Character.toLowerCase(chr);
            if (chr != 'a' && chr != 'e' && chr != 'i' && chr != 'o' && chr != 'u') {
                return true;
            }
        }
        return false;
    }
    
    private void setCache(String str, HashMap<Character, Integer> map) {
        cache.put(str, map);
    }
    
    private HashMap<Character, Integer> getCache(String str) {
        return cache.get(str);
    }
    
    public void print(String str) {
        HashMap<Character, Integer> map = countUniqueCharachters(str);
        System.out.println(str);
        System.out.println("The number of unique characters in the current line");
        for(Map.Entry<Character, Integer> item : map.entrySet()) {
            System.out.println("\"" + item.getKey() + "\" - " + item.getValue());
        }
    }
}
