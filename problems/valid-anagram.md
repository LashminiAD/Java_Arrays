# Valid Anagram

## Problem
Given two strings `s` and `t`, return `true` if the two strings are anagrams of each other, otherwise return `false`.

An anagram is a string that contains the exact same characters as another string, but the order of characters can be different.

## Example

Input  
s = "racecar"  
t = "carrace"

Output  
true

Input  
s = "jar"  
t = "jam"

Output  
false

## Idea

If two strings are anagrams:
- They must have the **same length**
- They must have the **same character frequency**

Use an array of size **26** to store character counts.

## Approach

1. If lengths are different → return false.
2. Create `int[26]` array.
3. Traverse both strings:
   - Increment count for characters in `s`
   - Decrement count for characters in `t`
4. If all counts become `0`, they are anagrams.

## Time Complexity
O(n)

## Space Complexity
O(1)
