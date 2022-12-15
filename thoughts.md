# Thoughts
## Purpose
This file is more of a scratch pad where I am organizing my thoughts and plan of action.

## Prompt
--- Day 3: Rucksack Reorganization ---
One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.

Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.

The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need your help finding the errors. Every item type is identified by a single lowercase or uppercase letter (that is, a and A refer to different types of items).

The list of items for each rucksack is given as characters all on a single line. A given rucksack always has the same number of items in each of its two compartments, so the first half of the characters represent items in the first compartment, while the second half of the characters represent items in the second compartment.

For example, suppose you have the following list of contents from six rucksacks:

```
vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
```
- The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp. The only item type that appears in both compartments is lowercase p.
- The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is uppercase L.
- The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
- The fourth rucksack's compartments only share item type v.
- The fifth rucksack's compartments only share item type t.
- The sixth rucksack's compartments only share item type s.
- To help prioritize item rearrangement, every item type can be converted to a priority:

Lowercase item types a through z have priorities 1 through 26.
Uppercase item types A through Z have priorities 27 through 52.
In the above example, the priority of the item type that appears in both compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.

Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?

## Initial thoughts
My first instinct is to create classes to represent the rucksacks with two compartment fields. However, I think I need to
step back and try to approach it from the expected output
- I need to find the sum of each corresponding string from each rucksack
  - number <- reduce <- string[] <- map <- string[]
  - int <- reducer? <- Character List<> <- map <- string List<Data Object>

Looking at the above I get the impression that is a functional approach.

OOP attempt
- What is my data?
  - a list of strings that represent a rucksack and it's two compartments
- What should happen to the data?
  - Turn into an integer
- Rucksacks have an inventory list associated with each. So a rucksack should be able to identify the duplicate
- An elf should be responsible for calculating the priority value total.

## After successful first solution problem 1
My initial plan came across a few snags. 
- I did not account for using a Character object instead of a String object in the initial
plan. This was a minor problem. Did not affect overall approach.
- When implementing I found myself wanting to pass the result of a method call for another method call. I did not plan
out the classes and I found having to second guess what data went where.

This solution is very rigid. Expects a specific file with a specific input. Classes are tied together. I should 
into generics.

## Part 2
--- Part Two ---
As you finish identifying the misplaced items, the Elves come to you with another issue.

For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group. For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves. That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack, and at most two of the Elves will be carrying any other item type.

The problem is that someone forgot to put this year's updated authenticity sticker on the badges. All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.

Additionally, nobody wrote down which item type corresponds to each group's badges. The only way to tell which item type is the right one is by finding the one item type that is common between all three Elves in each group.

Every set of three lines in your list corresponds to a single group, but each group can have a different badge item type. So, in the above example, the first group's rucksacks are the first three lines:
```
vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
```
And the second group's rucksacks are the next three lines:
```
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
```
In the first group, the only item type that appears in all three rucksacks is lowercase r; this must be their badges. In the second group, their badge item type must be Z.

Priorities for these items must still be found to organize the sticker attachment efforts: here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.

Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?

## Thoughts part 2
I am going to move forward with the assumptions that the first 3 entries is a group and that the file is divisible by 3.
I am also assuming that each group has to have at least 1 'badge' in common.

My current solution should be able to work without modifying the original code. Unfortunately less than half is useful to me.

I should be able to refactor the Rucksack to save the hashset with both compartment strings. Then create a method that maps
the common badge using the built in hashset. Then pass it back into the ElfEmployee class to be added up together.

## Final thoughts
I thought it was going to be more of a struggle to refactor the original code. Fortunately I did not have to change much.
Unfortunately I was unable to use most of it. I did try to extract the logic for calculating the priority value.
As it turns out the priority value was something I had to use and would have benefited me to make it a static method.

The problem was fun. I need to work on my speed. This problem took me four hours. I should try to bring this time down to
one hour.