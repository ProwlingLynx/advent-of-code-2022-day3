package rucksacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RucksackTest {

    @Test
    void getDuplicateType() {
        IRucksack testObject = new Rucksack("pvJrwWtwJgWrhcsFMMfFFhFp");
        Character expected = 'p';
        Character actual = testObject.getDuplicateType();
        assertEquals(actual, expected);
    }
}