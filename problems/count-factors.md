# Count Factors/Divisors - Problem Statement

**Difficulty**: Easy  
**Platform Links**:
- [LeetCode - Divisor Game](https://leetcode.com/problems/divisor-game/)
- [GeeksforGeeks - Count Divisors](https://www.geeksforgeeks.org/count-divisors-of-n-in-on-time-complexity/)
- [HackerRank - Divisor Game](https://www.hackerrank.com/challenges/divisor-game/problem)

Given an integer `n`, count the **total number of divisors** (factors) of `n`.

## Approaches

### Approach 1: √n Iteration (Optimal)
Iterate from 1 to √n. For each divisor i, count both i and n/i (if they are different).
- **Logic**: Avoid redundant counting by only checking up to √n.
- **Time**: O(√n)
- **Space**: O(1)

### Approach 2: Prime Factorization
Express n as a product of prime factors with their powers. Use the formula: if n = p₁^a₁ × p₂^a₂ × ... × pₖ^aₖ, then divisor count = (a₁ + 1) × (a₂ + 1) × ... × (aₖ + 1)
- **Logic**: Count based on prime factorization formula.
- **Time**: O(√n)
- **Space**: O(1)

### Approach 3: Brute Force
Iterate from 1 to n and count all divisors.
- **Logic**: Direct approach without optimization.
- **Time**: O(n)
- **Space**: O(1)

## Time Complexity Comparison
| Approach | Time Complexity | Space Complexity | Notes |
|----------|-----------------|------------------|-------|
| √n Iteration | O(√n) | O(1) | **Recommended** |
| Prime Factorization | O(√n) | O(1) | Alternative optimal |
| Brute Force | O(n) | O(1) | Too slow |

## Dry Run Examples

**Test Case 1**: `n = 6`
- √6 ≈ 2.45, iterate i from 1 to 2
- i = 1 → 6 % 1 = 0 → count++ (count = 1), 1 ≠ 6/1 → count++ (count = 2)
  - Divisors added: 1, 6
- i = 2 → 6 % 2 = 0 → count++ (count = 3), 2 ≠ 6/2=3 → count++ (count = 4)
  - Divisors added: 2, 3
- **Output: 4**
- Divisors are: [1, 2, 3, 6]

**Test Case 2**: `n = 16`
- √16 = 4, iterate i from 1 to 4
- i = 1 → 16 % 1 = 0 → count = 2 (adds 1, 16)
- i = 2 → 16 % 2 = 0 → count = 4 (adds 2, 8)
- i = 3 → 16 % 3 ≠ 0 → skip
- i = 4 → 16 % 4 = 0 → count = 5 (adds 4, but 4 = 16/4 so count only once)
- **Output: 5**
- Divisors are: [1, 2, 4, 8, 16]

**Test Case 3**: `n = 1`
- √1 = 1, iterate i from 1 to 1
- i = 1 → 1 % 1 = 0 → count = 1 (adds 1, but 1 = 1/1 so count only once)
- **Output: 1**
- Divisors are: [1]

**Test Case 4**: `n = 28`
- √28 ≈ 5.29, iterate i from 1 to 5
- i = 1 → count = 2 (adds 1, 28)
- i = 2 → count = 4 (adds 2, 14)
- i = 3 → skip
- i = 4 → count = 6 (adds 4, 7)
- i = 5 → skip
- **Output: 6**
- Divisors are: [1, 2, 4, 7, 14, 28]