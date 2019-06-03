package ua.com.foxminded.numberUniqueCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Counter {
    private HashMap<String, HashMap<Character, Integer>> cache = new HashMap<String, HashMap<Character, Integer>>();
    private HashMap<Character, Integer> globalMap = new HashMap<Character, Integer>();
    private ArrayList<String> arrOfSequences = new ArrayList<String>();
    
//    1) The number of unique characters in the current line
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
    
    public String printNumbersUniqueCharachters(String str) {
        HashMap<Character, Integer> map = countUniqueCharachters(str);
        String output = str + "\n" + "The number of unique characters in the current line\n";
        for(Map.Entry<Character, Integer> item : map.entrySet()) {
            output += "\"" + item.getKey() + "\" - " + item.getValue() + "\n";
        }
        System.out.print(output);
        return output;
    }
    
//    2) How many times the particular character appears in the global text
    public HashMap<Character, Integer> addStringToGlobalMap(String str) {
        for (int i = 0; i < str.length(); i++) {
            Integer frequency = globalMap.get(str.charAt(i));
            globalMap.put(str.charAt(i), frequency == null ? 1 : frequency + 1);
        }
        setCache(str, countUniqueCharachters(str));
    return globalMap;
}
    
    public String printNumbersUniqueCharachtersInGlobalText() {
        String output = "The number of unique characters in the global text\n";
        for(Map.Entry<Character,Integer> item : globalMap.entrySet()) {
            output += "\"" + item.getKey() + "\" - " + item.getValue() + "\n";
        }
        System.out.println(output);
        return output;
    }
    
//    3) How many vowels and consonants in the current line
    public int countVowels(String str) {
        int vowels = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                vowels++;
            } 
        }
        return vowels;
    }
    
    public int countConsonants(String str) {
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isConsonant(str.charAt(i))) {
                consonants++;
            } 
        }
        return consonants;
    }
  
    private boolean isVowel(Character chr) {
        if ((chr >= 'a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z')) {
            chr = Character.toLowerCase(chr);
            if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u') {
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
      
    public String printNumbersOfCharactersTypes(String str) {
        String output = "";
        output += "Number of vowels: " + countVowels(str) + "\n";
        output += "Number of consonants: " + countConsonants(str) + "\n"; 
        System.out.println(output);
        return output;
    }

    
//    4) How many continuous consonant sequences in the line
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
    
    public String printContinuousConsonantSequences(String str) {
        String output = "There are " + countConsonantSequences(str) + " continuous consonant sequences in the line: ";
        for (String item : arrOfSequences) {
            output += item + " ";
        }
        System.out.println(output + "\n");
        return output;
    }
    
//    5) For each symbol the minimal and maximal index of it in the line
    public String printMinMaxIndexForSymbol(String str) {
        Integer min;
        Integer max;
        String output = "";
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
            output += "For symbol '" + entryMin.getKey() + "' minimal index is " + entryMin.getValue() + 
                    ", maximal index is " + entryMax.getValue() + "\n";
        }
        System.out.println(output);
        return output;
    }
    
    private void setCache(String str, HashMap<Character, Integer> map) {
        cache.put(str, map);
    }
    
    private HashMap<Character, Integer> getCache(String str) {
        return cache.get(str);
    }
}
