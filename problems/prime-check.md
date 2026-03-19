# Prime Check Problem Statement

**Difficulty**: Easy  
**Platform Links**:
- [LeetCode - Valid Perfect Square (Similar)](https://leetcode.com/problems/valid-perfect-square/)
- [GeeksforGeeks - Prime Check](https://www.geeksforgeeks.org/prime-number/)
- [HackerRank - Prime Checking](https://www.hackerrank.com/challenges/is-prime/problem)

Given an integer `n`, determine whether it is a prime number. A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.

## Approaches

### Approach 1: Brute Force (Optimized)
Check divisibility from 2 up to √n. If any number divides n, it's not prime.
- **Logic**: Only check up to √n because if a number has a divisor greater than √n, it must also have a divisor less than √n.
- **Time**: O(√n)
- **Space**: O(1)

### Approach 2: Trial Division (All even check first)
First check if n is even, then check odd divisors from 3 to √n.
- **Logic**: Check if divisible by 2, then check only odd numbers to reduce iterations by half.
- **Time**: O(√n)
- **Space**: O(1)

### Approach 3: Sieve Method (for multiple queries)
Pre-compute all primes using Sieve of Eratosthenes.
- **Logic**: If you need to check primality for multiple numbers, sieve is more efficient.
- **Time**: O(n log log n) for preprocessing + O(1) per query
- **Space**: O(n)

## Time Complexity Comparison
| Approach | Time Complexity | Space Complexity | Notes |
|----------|-----------------|------------------|-------|
| Brute Force | O(√n) | O(1) | Best for single query |
| Optimized Trial Division | O(√n) | O(1) | Slightly faster than brute force |
| Sieve of Eratosthenes | O(n log log n) + O(1) | O(n) | Better for multiple queries |

## Dry Run Example
**Test Case 1**: `n = 7`
- Check if n <= 1? No
- i = 2 → i² = 4 ≤ 7 → 7 % 2 = 1 ≠ 0 → Continue
- i = 3 → i² = 9 > 7 → Loop ends
- No divisor found → **Output: true (7 is prime)**

**Test Case 2**: `n = 10`
- Check if n <= 1? No
- i = 2 → i² = 4 ≤ 10 → 10 % 2 = 0 → **Output: false (10 is not prime)**

**Test Case 3**: `n = 1`
- Check if n <= 1? Yes → **Output: false (1 is not prime)**

**Test Case 4**: `n = 2`
- Check if n <= 1? No
- i = 2 → i² = 4 > 2 → Loop ends
- No divisor found → **Output: true (2 is prime)**
