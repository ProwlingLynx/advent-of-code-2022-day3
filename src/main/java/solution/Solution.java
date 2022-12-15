package solution;

import elfemployee.ElfEmployee;

public class Solution {
    public static void main(String[] args) {
        ElfEmployee elf = new ElfEmployee("src/main/resources/problemOneInput.txt");
        System.out.println(elf.calculateTotalPriorityValue());
        System.out.println(elf.calculateElfBadgePriorityValue());
    }
}
