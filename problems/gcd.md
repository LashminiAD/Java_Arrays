# GCD (Greatest Common Divisor) - Problem Statement

**Difficulty**: Easy  
**Platform Links**:
- [LeetCode - GCD of Strings](https://leetcode.com/problems/gcd-of-strings/)
- [GeeksforGeeks - GCD](https://www.geeksforgeeks.org/gcd-greatest-common-divisor-explained/)
- [HackerRank - GCD](https://www.hackerrank.com/challenges/gcd/problem)

Given two integers `a` and `b`, find the **Greatest Common Divisor (GCD)** using the **Euclidean Algorithm**.

## Approaches

### Approach 1: Euclidean Algorithm (Recursive)
Use the property: GCD(a, b) = GCD(b, a % b). Recursively apply until b becomes 0.
- **Logic**: At each step, reduce the problem to smaller numbers.
- **Time**: O(log(min(a, b)))
- **Space**: O(log(min(a, b))) due to recursion stack

### Approach 2: Euclidean Algorithm (Iterative) - RECOMMENDED
Same as recursive but using a loop instead of recursion.
- **Logic**: More memory efficient, avoids recursion overhead.
- **Time**: O(log(min(a, b)))
- **Space**: O(1)

### Approach 3: Subtraction Method
Replace the larger number with (larger - smaller) repeatedly until both are equal.
- **Logic**: GCD(a, b) = GCD(a - b, b) if a > b
- **Time**: O(max(a, b))
- **Space**: O(1)

### Approach 4: Brute Force
Check all numbers from 1 to min(a, b) and find the largest divisor.
- **Logic**: Direct but inefficient.
- **Time**: O(min(a, b))
- **Space**: O(1)

## Time Complexity Comparison
| Approach | Time Complexity | Space Complexity | Notes |
|----------|-----------------|------------------|-------|
| Euclidean (Iterative) | O(log(min(a, b))) | O(1) | **Best** |
| Euclidean (Recursive) | O(log(min(a, b))) | O(log(min(a, b))) | Recursive overhead |
| Subtraction | O(max(a, b)) | O(1) | Much slower |
| Brute Force | O(min(a, b)) | O(1) | Inefficient |

## Dry Run Examples

**Example 1**: `a = 12, b = 18`
- Step 1: gcd(18, 12 % 18) = gcd(18, 12)
- Step 2: gcd(12, 18 % 12) = gcd(12, 6)
- Step 3: gcd(6, 12 % 6) = gcd(6, 0)
- b = 0, return 6
- **Output: 6**
- Verification: 12 = 2² × 3, 18 = 2 × 3² → GCD = 2 × 3 = 6

**Example 2**: `a = 48, b = 18`
- Step 1: gcd(18, 48 % 18) = gcd(18, 12)
- Step 2: gcd(12, 18 % 12) = gcd(12, 6)
- Step 3: gcd(6, 12 % 6) = gcd(6, 0)
- b = 0, return 6
- **Output: 6**

**Example 3**: `a = 17, b = 5`
- Step 1: gcd(5, 17 % 5) = gcd(5, 2)
- Step 2: gcd(2, 5 % 2) = gcd(2, 1)
- Step 3: gcd(1, 2 % 1) = gcd(1, 0)
- b = 0, return 1
- **Output: 1** (17 and 5 are coprime)

**Example 4**: `a = 100, b = 50`
- Step 1: gcd(50, 100 % 50) = gcd(50, 0)
- b = 0, return 50
- **Output: 50** (50 divides 100 evenly)

**Example 5**: `a = 0, b = 5`
- Step 1: gcd(5, 0 % 5) = gcd(5, 0)
- b = 0, return 5
- **Output: 5**

## Key Properties
1. GCD(a, b) = GCD(b, a % b)
2. GCD(a, 0) = a
3. GCD(a, a) = a
4. GCD(a, b) = GCD(b, a) (commutative)
5. If GCD(a, b) = 1, then a and b are coprime