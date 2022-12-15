package elfemployee;

import filereader.FileReader;
import rucksacks.IRucksack;
import rucksacks.Rucksack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ElfEmployee {
    List<IRucksack> rucksacks;
    public ElfEmployee(String manifestFilePath){
        try{
            FileReader fr = new FileReader(manifestFilePath);
            List<String> rucksackContents = fr.readListOfRucksackContents();
            setRucksacksFromContents(rucksackContents);
        } catch (Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
    private void setRucksacksFromContents(List<String> rucksackContent){
        rucksacks = new ArrayList<>();
        for(String contents : rucksackContent){
            rucksacks.add(new Rucksack(contents));
        }
    }
    private int getPriorityValue(IRucksack rucksack){
        int charCode = rucksack.getDuplicateType();
        if (charCode < 97){
            return charCode - 38;
        } else {
            return charCode - 96;
        }
    }
    public int calculateTotalPriorityValue(){
        int total = 0;
        for(IRucksack rucksack: rucksacks){
            total += getPriorityValue(rucksack);
        }
        return total;
    }
    public int calculateElfBadgePriorityValue(){
        int total = 0;
        for (int i = 0; i < rucksacks.size(); i+= 3){
            HashSet<Character> elf1 = rucksacks.get(i).getHashSetOfContent();
            HashSet<Character> elf2 = rucksacks.get(i + 1).getHashSetOfContent();
            HashSet<Character> elf3 = rucksacks.get(i + 2).getHashSetOfContent();
            for (Character type: elf1){
                if (elf2.contains(type) && elf3.contains(type)){
                    int charCode = type;
                    if (charCode < 97){
                        total += (charCode - 38);
                    } else {
                        total += (charCode - 96);
                    }
                    break;
                }
            }
        }
        return total;
    }
}
