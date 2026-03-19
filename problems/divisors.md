# Divisors of a Number - Problem Statement

**Difficulty**: Easy  
**Platform Links**:
- [LeetCode - Divisors of a Number (Similar)](https://leetcode.com/problems/divisors-an-integer-has/)
- [GeeksforGeeks - Find all Divisors](https://www.geeksforgeeks.org/find-all-divisors-of-a-number-set-1/)
- [HackerRank - Divisors and Multiples](https://www.hackerrank.com/challenges/find-divisors/problem)

Given an integer `n`, find all divisors (factors) of `n` and return them in **ascending order**.

## Approaches

### Approach 1: Brute Force (√n Optimization)
Iterate from 1 to √n. For each i that divides n, add both i and n/i as divisors.
- **Logic**: For every divisor i ≤ √n, there exists a corresponding divisor n/i ≥ √n.
- **Time**: O(√n log √n) for sorting
- **Space**: O(d) where d = number of divisors

### Approach 2: Two Pointer (for sorted output without sorting)
Use two pointers: one starting at 1, one ending at √n.
- **Logic**: Similar to approach 1 but arranges output in order while collecting.
- **Time**: O(√n)
- **Space**: O(d)

### Approach 3: Brute Force (Simple but slow)
Iterate from 1 to n and check if i divides n.
- **Logic**: Direct approach without optimization.
- **Time**: O(n)
- **Space**: O(d)

## Time Complexity Comparison
| Approach | Time Complexity | Space Complexity | Notes |
|----------|-----------------|------------------|-------|
| √n Optimization + Sort | O(√n + d log d) | O(d) | Recommended |
| Brute Force | O(n) | O(d) | Too slow for large n |

## Dry Run Example
**Input**: `n = 36`

**Step-by-step using √n approach**:
- √36 = 6, so we iterate i from 1 to 6
- i = 1 → 36 % 1 = 0 → Add 1 and 36 → [1, 36]
- i = 2 → 36 % 2 = 0 → Add 2 and 18 → [1, 36, 2, 18]
- i = 3 → 36 % 3 = 0 → Add 3 and 12 → [1, 36, 2, 18, 3, 12]
- i = 4 → 36 % 4 = 0 → Add 4 and 9 → [1, 36, 2, 18, 3, 12, 4, 9]
- i = 5 → 36 % 5 ≠ 0 → Skip
- i = 6 → 36 % 6 = 0 → Add 6, but 6 = 36/6 so add only once → [1, 36, 2, 18, 3, 12, 4, 9, 6]

**After sorting**: `[1, 2, 3, 4, 6, 9, 12, 18, 36]`

**Another Example**: `n = 12`
- √12 ≈ 3.46, so iterate i from 1 to 3
- i = 1 → 12 % 1 = 0 → [1, 12]
- i = 2 → 12 % 2 = 0 → [1, 12, 2, 6]
- i = 3 → 12 % 3 = 0 → [1, 12, 2, 6, 3, 4]

**After sorting**: `[1, 2, 3, 4, 6, 12]`