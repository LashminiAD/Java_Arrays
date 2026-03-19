# Armstrong Number - Problem Statement

**Difficulty**: Medium  
**Platform Links**:
- [LeetCode - Armstrong Number (Similar)](https://leetcode.com/problems/armstrong-number/)
- [GeeksforGeeks - Armstrong Number](https://www.geeksforgeeks.org/armstrong-numbers/)
- [HackerRank - Armstrong Numbers](https://www.hackerrank.com/challenges/armstrong-numbers/problem)

Given an integer `n`, determine if it is an **Armstrong Number** (also called a narcissistic number).

An Armstrong number is a number that equals the sum of its own digits each raised to the power of the number of digits.

**Formula**: For a number with d digits: n = a₁^d + a₂^d + ... + aₖ^d, where a₁, a₂, ..., aₖ are the individual digits.

## Approaches

### Approach 1: Direct Calculation (Recommended)
Count the digits, then calculate the sum of each digit raised to that power.
- **Logic**: Extract each digit using modulo, raise to power, sum, and compare with original.
- **Time**: O(d) where d = number of digits
- **Space**: O(1)

### Approach 2: String Conversion
Convert number to string to easily access each digit.
- **Logic**: Iterate through string characters, convert to int, raise to power.
- **Time**: O(d)
- **Space**: O(d) for string storage

### Approach 3: Pre-computed Check (Fixed Range)
Pre-compute all Armstrong numbers up to a certain limit and store in a set/list.
- **Logic**: For limited range (e.g., up to 10^9), pre-compute and use lookup.
- **Time**: O(1) for query (after preprocessing)
- **Space**: O(number of Armstrong numbers in range)

## Time Complexity Comparison
| Approach | Time Complexity | Space Complexity | Notes |
|----------|-----------------|------------------|-------|
| Direct Calculation | O(d) | O(1) | **Recommended** |
| String Conversion | O(d) | O(d) | Easier to code |
| Pre-computed | O(1) | O(m) | m = Armstrong count |

## Dry Run Examples

**Example 1**: `n = 153` (Armstrong number)
- Digits: 1, 5, 3
- Number of digits: 3
- Calculation: 1³ + 5³ + 3³ = 1 + 125 + 27 = 153
- 153 == 153 → **Output: true**

**Example 2**: `n = 123` (NOT Armstrong)
- Digits: 1, 2, 3
- Number of digits: 3
- Calculation: 1³ + 2³ + 3³ = 1 + 8 + 27 = 36
- 36 ≠ 123 → **Output: false**

**Example 3**: `n = 9474` (Armstrong number)
- Digits: 9, 4, 7, 4
- Number of digits: 4
- Calculation: 9⁴ + 4⁴ + 7⁴ + 4⁴ = 6561 + 256 + 2401 + 256 = 9474
- 9474 == 9474 → **Output: true**

**Example 4**: `n = 1634` (Armstrong number)
- Digits: 1, 6, 3, 4
- Number of digits: 4
- Calculation: 1⁴ + 6⁴ + 3⁴ + 4⁴ = 1 + 1296 + 81 + 256 = 1634
- 1634 == 1634 → **Output: true**

**Example 5**: `n = 5` (Armstrong number - single digit)
- Digits: 5
- Number of digits: 1
- Calculation: 5¹ = 5
- 5 == 5 → **Output: true**
- (All single-digit numbers are Armstrong numbers)

**Example 6**: `n = 10` (NOT Armstrong)
- Digits: 1, 0
- Number of digits: 2
- Calculation: 1² + 0² = 1 + 0 = 1
- 1 ≠ 10 → **Output: false**

**Example 7**: `n = 370` (Armstrong number)
- Digits: 3, 7, 0
- Number of digits: 3
- Calculation: 3³ + 7³ + 0³ = 27 + 343 + 0 = 370
- 370 == 370 → **Output: true**

## Well-Known Armstrong Numbers
| Category | Numbers |
|----------|---------|
| 1-digit | 1, 2, 3, 4, 5, 6, 7, 8, 9 (All single digits) |
| 2-digit | None |
| 3-digit | 153, 370, 371, 407 |
| 4-digit | 1634, 8208, 9474 |
| 5-digit | 54748, 92727, 93084 |

## Step-by-step Algorithm
1. Store original number
2. Count the number of digits
3. Initialize sum = 0
4. Extract each digit from right to left (using modulo 10)
5. Raise each digit to the power of digit count and add to sum
6. Compare sum with original number
7. Return true if equal, false otherwise