package elfemployee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfEmployeeTest {

    @Test
    void calculateTotalPriorityValue() {
        ElfEmployee elf = new ElfEmployee("src/main/resources/sampleInput.txt");
        int expected = 157;
        int actual = elf.calculateTotalPriorityValue();
        assertEquals(expected, actual);
    }
}