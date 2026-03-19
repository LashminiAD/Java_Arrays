# Prime Factors (Unique) - Problem Statement

**Difficulty**: Medium  
**Platform Links**:
- [LeetCode - Prime Number of Set Bits (Related)](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/)
- [GeeksforGeeks - Prime Factorization](https://www.geeksforgeeks.org/print-all-prime-factors-of-a-number/)
- [HackerRank - Prime Factorization](https://www.hackerrank.com/challenges/prime-factorization/problem)

Given an integer `n`, find all **unique prime factors** and return them in ascending order.

**Distinction**: Prime factors (all occurrences) vs Unique prime factors (no duplicates).
- Prime factors of 60: [2, 2, 3, 5]
- **Unique prime factors of 60: [2, 3, 5]**

## Approaches

### Approach 1: Trial Division with √n (Recommended)
Divide n by each potential factor from 2 to √n. For each factor, divide it out completely.
- **Logic**: Eliminate all occurrences of each prime factor before moving to the next.
- **Time**: O(√n)
- **Space**: O(k) where k = number of unique prime factors

### Approach 2: Optimized Trial Division (Even number check first)
First handle factor 2 separately, then check only odd numbers from 3 to √n.
- **Logic**: Reduces iterations by half.
- **Time**: O(√n)
- **Space**: O(k)

### Approach 3: Prime Sieve + Trial Division
Pre-compute all primes up to √n using sieve, then check only those primes.
- **Logic**: Check only prime numbers as factors.
- **Time**: O(√n + p log log p) where p = √n
- **Space**: O(√n) for sieve + O(k) for factors

### Approach 4: Brute Force
Check all numbers from 2 to √n as potential factors.
- **Logic**: Simple but may check non-prime factors.
- **Time**: O(√n)
- **Space**: O(k)

## Time Complexity Comparison
| Approach | Time Complexity | Space Complexity | Notes |
|----------|-----------------|------------------|-------|
| Trial Division | O(√n) | O(k) | **Recommended** |
| Optimized Trial | O(√n) | O(k) | Slightly faster |
| Sieve + Trial | O(√n log log √n) | O(√n + k) | For multiple queries |
| Brute Force | O(√n) | O(k) | Simpler code |

## Dry Run Examples

**Example 1**: `n = 60`
- Start: n = 60, factors = []
- i = 2 → 60 % 2 = 0 → Add 2, divide: 60 → 30 → 15 (stop, 15 % 2 ≠ 0), n = 15
- i = 3 → 3² = 9 ≤ 15 → 15 % 3 = 0 → Add 3, divide: 15 → 5 (stop, 5 % 3 ≠ 0), n = 5
- i = 4 → 4² = 16 > 5 → Loop ends
- n = 5 > 1 → Add 5
- **Output: [2, 3, 5]**

**Example 2**: `n = 84`
- 84 = 2² × 3 × 7
- Start: n = 84, factors = []
- i = 2 → 84 % 2 = 0 → Add 2, divide: 84 → 42 → 21 (stop), n = 21
- i = 3 → 21 % 3 = 0 → Add 3, divide: 21 → 7 (stop), n = 7
- i = 4 → 4² = 16 > 7 → Loop ends
- n = 7 > 1 → Add 7
- **Output: [2, 3, 7]**

**Example 3**: `n = 100`
- 100 = 2² × 5²
- Start: n = 100, factors = []
- i = 2 → 100 % 2 = 0 → Add 2, divide: 100 → 50 → 25 (stop), n = 25
- i = 3 → 25 % 3 ≠ 0 → Skip
- i = 4 → 25 % 4 ≠ 0 → Skip
- i = 5 → 25 % 5 = 0 → Add 5, divide: 25 → 5 → 1 (stop), n = 1
- n = 1, exit loop
- **Output: [2, 5]**

**Example 4**: `n = 17` (Prime number)
- Start: n = 17, factors = []
- i = 2 → 17 % 2 ≠ 0 → Skip
- i = 3 → 17 % 3 ≠ 0 → Skip
- i = 4 → 4² = 16 < 17 → 17 % 4 ≠ 0 → Skip
- i = 5 → 5² = 25 > 17 → Loop ends
- n = 17 > 1 → Add 17
- **Output: [17]**

**Example 5**: `n = 2` (Smallest prime)
- Start: n = 2, factors = []
- i = 2 → 2² = 4 > 2 → Loop doesn't execute
- n = 2 > 1 → Add 2
- **Output: [2]**

**Example 6**: `n = 1`
- Start: n = 1, factors = []
- i = 2 → 2² = 4 > 1 → Loop doesn't execute
- n = 1, not > 1 → Don't add
- **Output: []** (1 has no prime factors)