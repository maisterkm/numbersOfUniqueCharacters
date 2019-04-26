package ua.com.foxminded.numberUniqueCharacters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
        map = new HashMap<Character, Integer>();
        expected = new HashMap<Character, Integer>();
    }

    @Test
    public void returnShouldNotBeEmpty() {
        map = counter.countUniqueCharachters("hello world!");
        assertFalse(map.isEmpty());
    }

    @Test
    public void returnShouldNotBeNull() {
        map = counter.countUniqueCharachters("hello world!");
        assertNotNull(map);
    }
    
    @Test
    public void shouldReturnExpectedMap() {
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

}
