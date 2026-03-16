# Second Largest Element in Array

## Problem
Given an array of positive integers `arr[]`, return the **second largest element** in the array.

If the second largest element does not exist, return `-1`.

The second largest element must be **different from the largest element**.

## Example

Input  
arr = [12,35,1,10,34,1]

Output  
34

Explanation  
Largest = 35  
Second Largest = 34

Input  
arr = [10,5,10]

Output  
5

Input  
arr = [10,10,10]

Output  
-1

## Idea

Maintain two variables:

- `largest`
- `secondLargest`

Update them while traversing the array.

## Approach

1. Initialize
   - `largest = -∞`
   - `secondLargest = -∞`

2. Traverse array:
   - If element > largest  
        update secondLargest = largest  
        update largest
   - Else if element < largest AND element > secondLargest  
        update secondLargest

3. If secondLargest still equals `-∞` → return -1.

## Time Complexity
O(n)

## Space Complexity
O(1)
