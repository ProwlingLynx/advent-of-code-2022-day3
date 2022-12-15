package filereader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.util.Arrays;
import java.util.List;

class FileReaderTest {
    @Test
    void readListOfRucksackContents() {
        List<String> expected = Arrays.asList("vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw");
        String filePath = "src/main/resources/sampleInput.txt";
        try{
            FileReader fr = new FileReader(filePath);
            List<String> actual = fr.readListOfRucksackContents();
            assertIterableEquals(expected, actual);
        } catch (Exception e){
            System.out.println("Exception thrown");
        }

    }
}