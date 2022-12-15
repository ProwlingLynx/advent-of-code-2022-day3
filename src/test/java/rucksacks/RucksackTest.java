package rucksacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RucksackTest {
    IRucksack testRucksack;
    @BeforeEach
    void setup(){
        testRucksack = new Rucksack("pvJrwWtwJgWrhcsFMMfFFhFp");
    }
    @Test
    void getDuplicateType() {
        Character expected = 'p';
        Character actual = testRucksack.getDuplicateType();
        assertEquals(actual, expected);
    }
    @Test
    void getHashSetOfContent(){
        String[] expected = "pvJrwWtwJgWrhcsFMMfFFhFp".split("");
        HashSet<Character> actualHash = testRucksack.getHashSetOfContent();
        for(String content: expected){
            assertTrue(actualHash.contains(content.charAt(0)));
        }
    }
}