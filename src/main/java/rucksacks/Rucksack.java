package rucksacks;

import java.util.HashSet;

public class Rucksack implements IRucksack{
    private final String compartment1;
    private final String compartment2;
    private Character duplicateType;

    public Rucksack(String rucksackContents){
        int lengthOfContents = rucksackContents.length();
        compartment1 = rucksackContents.substring(0, lengthOfContents/2);
        compartment2 = rucksackContents.substring(lengthOfContents/2);
        setDuplicate();
    }
    private void setDuplicate(){
        HashSet<Character> compartmentContents = new HashSet<>();
        for (int i = 0; i < compartment1.length(); i++){
            compartmentContents.add(compartment1.charAt(i));
        }
        for (int i = 0; i < compartment2.length(); i++){
            Character type = compartment2.charAt(i);
            if (compartmentContents.contains(type)){
                duplicateType = type;
                return;
            }
        }
    }
    @Override
    public Character getDuplicateType(){
        return duplicateType;
    }
    @Override
    public HashSet<Character> getHashSetOfContent(){
        HashSet<Character> hashedContents = new HashSet<>();
        for (int i = 0; i < compartment1.length(); i++){
            hashedContents.add(compartment1.charAt(i));
        }
        for (int i = 0; i < compartment2.length(); i++){
            hashedContents.add(compartment2.charAt(i));
        }
        return hashedContents;
    }
}
