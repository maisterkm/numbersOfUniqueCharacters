package ua.com.foxminded.numberUniqueCharacters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {
    Counter counter;
    HashMap<Character, Integer> map;
    HashMap<Character, Integer> expected;
    
    @Before
    public void before() {
        counter = new Counter();
        expected = new HashMap<Character, Integer>();
    }
    
    @Test
    public void countUniqueCharachtersShouldReturnExpectedMap() {
        map = counter.countUniqueCharachters("hello world!");
        map = counter.countUniqueCharachters("hello world!");
        expected = new HashMap<Character, Integer>();
        expected.put(' ', 1);
        expected.put('!', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        expected.put('e', 1);
        expected.put('w', 1);
        expected.put('h', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        assertTrue(map.equals(expected));
    }
    
    @Test
    public void printNumbersUniqueCharachtersShouldGenerateExpectedString() {
        String expected = "hello world!\n" + 
                          "The number of unique characters in the current line\n" + 
                          "\" \" - 1\n" + 
                          "\"!\" - 1\n" + 
                          "\"r\" - 1\n" + 
                          "\"d\" - 1\n" + 
                          "\"e\" - 1\n" + 
                          "\"w\" - 1\n" + 
                          "\"h\" - 1\n" + 
                          "\"l\" - 3\n" + 
                          "\"o\" - 2\n";
        assertEquals(expected, counter.printNumbersUniqueCharachters("hello world!"));
    }
    
    @Test
    public void addStringToGlobalMapShouldReturnExpectedMap() {
        HashMap<Character, Integer> globalMap = new HashMap<Character, Integer>();
        globalMap = counter.addStringToGlobalMap("ok");
        globalMap = counter.addStringToGlobalMap("ok");
        expected.put('k', 2);
        expected.put('o', 2);
        assertTrue(globalMap.equals(expected));
    }
    
    @Test
    public void printNumbersUniqueCharachtersInGlobalTextShouldGenerateExpectedString() {
        counter.addStringToGlobalMap("ok");
        counter.addStringToGlobalMap("ok");
        String expected = "The number of unique characters in the global text\n" + 
                          "\"k\" - 2\n" + 
                          "\"o\" - 2\n";
        assertEquals(expected, counter.printNumbersUniqueCharachtersInGlobalText());
    }
    
    @Test
    public void printNumbersOfCharactersTypesShouldGenerateExpectedString() {
        String str = "abcdefghijklmnopqrstuvwyz ,.:;_#!§$%&/ 123 456 7890 +-*/";
        String expected = "Number of vowels: 5\n" + 
                          "Number of consonants: 20\n";
        assertEquals(expected, counter.printNumbersOfCharactersTypes(str));
    }
    
    @Test
    public void printContinuousConsonantSequencesShouldGenerateExpectedString() {
        String expected = "There are 2 continuous consonant sequences in the line: ll rld ";
        assertEquals(expected, counter.printContinuousConsonantSequences("hello world!"));
    }
    
    @Test
    public void printMinMaxIndexForSymbolShouldGenerateExpectedString() {
        String expected = "For symbol ' ' minimal index is 3, maximal index is 3\n" + 
                          "For symbol 'a' minimal index is 0, maximal index is 6\n" + 
                          "For symbol 'b' minimal index is 1, maximal index is 5\n" + 
                          "For symbol 'c' minimal index is 2, maximal index is 4\n";
        assertEquals(expected, counter.printMinMaxIndexForSymbol("abc cba"));
    }

}
