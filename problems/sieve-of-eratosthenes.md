# Sieve of Eratosthenes - Problem Statement

**Difficulty**: Medium  
**Platform Links**:
- [LeetCode - Count Primes](https://leetcode.com/problems/count-the-number-of-prime-numbers-less-than-n/)
- [GeeksforGeeks - Sieve of Eratosthenes](https://www.geeksforgeeks.org/sieve-of-eratosthenes/)
- [HackerRank - Prime Challenge](https://www.hackerrank.com/challenges/prime-numbers-list/problem)

Given an integer `n`, find all **prime numbers less than or equal to n** using the **Sieve of Eratosthenes** algorithm.

**Why Sieve?**: When you need to find multiple primes in a range, sieve is much more efficient than checking each number individually.

## Approaches

### Approach 1: Sieve of Eratosthenes (Recommended)
Mark all multiples of each prime as non-prime, starting from the prime itself.
- **Logic**: 
  1. Create a boolean array of size n+1, initially all true
  2. Mark 0 and 1 as not prime
  3. For each number i from 2 to √n, if i is marked prime, mark all its multiples starting from i² as non-prime
  4. Collect all numbers still marked as prime
- **Time**: O(n log log n)
- **Space**: O(n)

### Approach 2: Optimized Sieve (Bitwise)
Same as Sieve but use bitwise operations to reduce space usage.
- **Logic**: Use bits instead of booleans to store prime status.
- **Time**: O(n log log n)
- **Space**: O(n/8) approximately

### Approach 3: Segmented Sieve (for very large ranges)
Divide the range into segments and apply sieve on each segment.
- **Logic**: Use for finding primes in large ranges like 10^9 to 10^9 + 10^5
- **Time**: O(n log log n)
- **Space**: O(√n + segment_size)

### Approach 4: Trial Division (without Sieve)
For each number, check if it's divisible by any prime up to √n.
- **Logic**: Less efficient for multiple queries.
- **Time**: O(n√n)
- **Space**: O(k) where k = number of primes

## Time Complexity Comparison
| Approach | Time Complexity | Space Complexity | Use Case |
|----------|-----------------|------------------|----------|
| Sieve | O(n log log n) | O(n) | **Best for moderate n** |
| Optimized Sieve | O(n log log n) | O(n/8) | When space is limited |
| Segmented Sieve | O(n log log n) | O(√n) | Very large ranges |
| Trial Division | O(n√n) | O(k) | Single query |

## Dry Run Example

**Input**: `n = 30`

**Step-by-step Sieve Process**:

Initial array (all true): [T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T]
Indices:                  [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]

**Step 1**: Mark 0 and 1 as false
Array: [F, F, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T]

**Step 2**: i = 2 (2 is prime, √30 ≈ 5.48)
- Mark multiples starting from 2² = 4: 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 as false
Array: [F, F, T, T, F, T, F, T, F, T, F, T, F, T, F, T, F, T, F, T, F, T, F, T, F, T, F, T, F, T, F]

**Step 3**: i = 3 (3 is prime)
- Mark multiples starting from 3² = 9: 9, 15, 21, 27 as false
Array: [F, F, T, T, F, T, F, T, F, F, F, T, F, T, F, F, F, T, F, T, F, F, F, T, F, T, F, F, F, T, F]

**Step 4**: i = 4 (4² = 16 > 30, but 4 is not prime anyway, skip)

**Step 5**: i = 5 (5 is prime, 5² = 25 ≤ 30)
- Mark multiples starting from 5² = 25: 25 as false
Array: [F, F, T, T, F, T, F, T, F, F, F, T, F, T, F, F, F, T, F, T, F, F, F, T, F, F, F, F, F, T, F]

**Step 6**: i = 6 (6² = 36 > 30, stop loop)

**Collect primes**: All indices with true values:
2, 3, 5, 7, 11, 13, 17, 19, 23, 29

**Output**: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

## More Examples

**Example 1**: `n = 10`
- Mark 0, 1 as false
- i = 2: Mark 4, 6, 8, 10 as false
- i = 3: Mark 9 as false
- i = 4: 4² > 10, stop
- **Output**: [2, 3, 5, 7]

**Example 2**: `n = 2`
- Mark 0, 1 as false
- i = 2: 2² = 4 > 2, stop
- **Output**: [2]

**Example 3**: `n = 1`
- Mark 0, 1 as false
- i = 2: 2² = 4 > 1, stop
- **Output**: [] (no primes)

## Why Start Marking from i²?
- All composite multiples of i less than i² have already been marked by smaller primes
- Example: For i = 5, multiples 10, 15, 20 are already marked by 2 and 3
- So we can start from 5² = 25, saving iterations

## Key Optimization: √n Limit
- Only iterate up to √n because any composite number n must have a factor ≤ √n
- For n = 30, √30 ≈ 5.48, so we only check up to 5
- Numbers 6, 7, 8, ... don't need to be checked as potential prime markers