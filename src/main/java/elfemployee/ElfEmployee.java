package elfemployee;

import filereader.FileReader;
import rucksacks.IRucksack;
import rucksacks.Rucksack;

import java.util.ArrayList;
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
    public int calculateTotalPriorityValue(){
        int total = 0;
        for(IRucksack rucksack: rucksacks){
            int charCode = rucksack.getDuplicateType();
            if (charCode < 97){
                total += charCode - 38;
            } else {
                total += charCode - 96;
            }
        }
        return total;
    }
}
