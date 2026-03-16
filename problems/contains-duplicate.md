# Contains Duplicate

## Problem
Given an integer array `nums`, return `true` if any value appears more than once in the array, otherwise return `false`.

## Example

Input  
nums = [1,2,3,3]

Output  
true

Input  
nums = [1,2,3,4]

Output  
false

## Idea

Use a **HashSet**.

A set cannot contain duplicate values.  
If we try to add an element that already exists → duplicate found.

## Approach

1. Create a `HashSet`.
2. Traverse the array.
3. If the element already exists in the set → return true.
4. Otherwise add it to the set.
5. If loop ends → return false.

## Time Complexity
O(n)

## Space Complexity
O(n)
