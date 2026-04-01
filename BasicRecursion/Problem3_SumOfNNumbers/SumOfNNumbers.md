# Problem 3: Sum of First N Natural Numbers

## Problem Statement
Given an integer **N**, find the **sum of first N natural numbers** using recursion.

**Examples:**
- Input: N = 4 → Output: 10 (1 + 2 + 3 + 4 = 10)
- Input: N = 5 → Output: 15 (1 + 2 + 3 + 4 + 5 = 15)
- Input: N = 0 → Output: 0 (no numbers)
- Input: N = 1 → Output: 1 (just 1)

---

## Understanding the Problem

### What We Need to Do:
```
N = 5:
Sum = 1 + 2 + 3 + 4 + 5 = 15

Break it down:
sum(5) = 5 + (1 + 2 + 3 + 4)
       = 5 + sum(4)
       
sum(4) = 4 + (1 + 2 + 3)
       = 4 + sum(3)

...and so on
```

### Why Use Recursion?
- **Natural**: The problem IS defined recursively
- **Mathematical**: sum(n) = n + sum(n-1)
- **Elegant**: Reflects the mathematical formula

---

## Solution Explanation

### Complete Code
```java
public static int sumOfNNumbers(int n) {
    // BASE CASE
    if (n == 0) {
        return 0;
    }
    
    // RECURSIVE CASE
    return n + sumOfNNumbers(n - 1);
}
```

### The Pattern: f(n) = n + f(n-1)

This is a **return value recursion pattern**:
- We RETURN the result of recursion
- We COMBINE it with current work
- Result flows back up the stack

---

## Step-by-Step Example: sum(4)

### Execution Trace

```
CALL 1: sumOfNNumbers(4)
  ├─ n = 4, not 0
  └─ return 4 + sumOfNNumbers(3)
     Waits for sumOfNNumbers(3)...

CALL 2: sumOfNNumbers(3)
  ├─ n = 3, not 0
  └─ return 3 + sumOfNNumbers(2)
     Waits for sumOfNNumbers(2)...

CALL 3: sumOfNNumbers(2)
  ├─ n = 2, not 0
  └─ return 2 + sumOfNNumbers(1)
     Waits for sumOfNNumbers(1)...

CALL 4: sumOfNNumbers(1)
  ├─ n = 1, not 0
  └─ return 1 + sumOfNNumbers(0)
     Waits for sumOfNNumbers(0)...

CALL 5: sumOfNNumbers(0)
  ├─ n = 0, BASE CASE!
  └─ return 0 ✓

UNWINDING (getting results):
sumOfNNumbers(0) returns: 0
sumOfNNumbers(1) returns: 1 + 0 = 1
sumOfNNumbers(2) returns: 2 + 1 = 3
sumOfNNumbers(3) returns: 3 + 3 = 6
sumOfNNumbers(4) returns: 4 + 6 = 10 ✓
```

### Mathematical Breakdown

```
sum(4) = 4 + sum(3)
       = 4 + (3 + sum(2))
       = 4 + (3 + (2 + sum(1)))
       = 4 + (3 + (2 + (1 + sum(0))))
       = 4 + (3 + (2 + (1 + 0)))
       = 4 + (3 + (2 + 1))
       = 4 + (3 + 3)
       = 4 + 6
       = 10 ✓
```

### Call Stack Visualization

```
BUILDING STACK (Forward):
┌─────────────────────────┐
│ sumOfNNumbers(0) = 0    │ ← Base case (depth 5)
│ sumOfNNumbers(1) = ?    │
│ sumOfNNumbers(2) = ?    │
│ sumOfNNumbers(3) = ?    │
│ sumOfNNumbers(4) = ?    │ ← Main call (depth 1)
└─────────────────────────┘

UNWINDING STACK (Backward):
sumOfNNumbers(0):
  returns 0

sumOfNNumbers(1):
  gets 0 from above
  calculates 1 + 0 = 1
  returns 1

sumOfNNumbers(2):
  gets 1 from above
  calculates 2 + 1 = 3
  returns 3

sumOfNNumbers(3):
  gets 3 from above
  calculates 3 + 3 = 6
  returns 6

sumOfNNumbers(4):
  gets 6 from above
  calculates 4 + 6 = 10
  returns 10 ✓ FINAL RESULT
```

### Complete Output

```
sum(5) = 15
sum(4) = 10
sum(1) = 1
sum(0) = 0
```

---

## How It Works

### Key Components

#### 1. Base Case: n == 0
```java
if (n == 0) {
    return 0;
}
```
- **Why 0?** Sum of no numbers is 0
- **When?** When we reach the smallest value
- **Result:** Stops recursion

#### 2. Recursive Case: n + sum(n-1)
```java
return n + sumOfNNumbers(n - 1);
```
- **What?** Current number + sum of rest
- **Why?** Builds up the total
- **Progress:** n-1 gets closer to 0

---

## Complexity Analysis

### Time Complexity: O(n)
```
For sumOfNNumbers(n):
- Makes n function calls: sumOfNNumbers(n), sumOfNNumbers(n-1), ..., sumOfNNumbers(0)
- Each call does O(1) work: one addition, one return
- Total: n × O(1) = O(n) ✓
```

**Example:**
```
sumOfNNumbers(5) makes:
- sumOfNNumbers(5)
- sumOfNNumbers(4)
- sumOfNNumbers(3)
- sumOfNNumbers(2)
- sumOfNNumbers(1)
- sumOfNNumbers(0)

Total: 6 calls (which is n+1, still O(n))
```

### Space Complexity: O(n)
```
Call stack depth for sumOfNNumbers(n):

sumOfNNumbers(5)
  ├─ sumOfNNumbers(4)
  │   ├─ sumOfNNumbers(3)
  │   │   ├─ sumOfNNumbers(2)
  │   │   │   ├─ sumOfNNumbers(1)
  │   │   │   │   └─ sumOfNNumbers(0)

Maximum depth: n + 1 = 6
Each frame: ~100 bytes (holds n, return address)
Total: ~600 bytes = O(n) ✓
```

---

## Alternative Solutions

### Solution 1: Iterative (Better Space)
```java
public static int sumIterative(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i;
    }
    return sum;
}

sumIterative(5);  // = 15

// Time: O(n) (same as recursive)
// Space: O(1) (much better!)
```

### Solution 2: Mathematical Formula (Best!)
```java
public static int sumFormula(int n) {
    return n * (n + 1) / 2;
}

sumFormula(5);  // = 5 * 6 / 2 = 15

// Time: O(1) (instant!)
// Space: O(1)
// Why? Math formula: 1+2+...+n = n*(n+1)/2
```

### Solution 3: Memoization (Optimized Recursion)
```java
public static class SumMemo {
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int sum(int n) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        
        int result = n + sum(n - 1);
        memo.put(n, result);
        return result;
    }
}

// Time: O(n) still, but avoids recomputation
// Space: O(n) for memo + O(n) for stack
```

### Comparison

| Approach | Time | Space | Use Case |
|----------|------|-------|----------|
| Recursion | O(n) | O(n) | Learning |
| Iterative | O(n) | O(1) | Safe & efficient |
| Formula | O(1) | O(1) | ⭐ Best |
| Memoization | O(n) | O(n) | Large inputs |

---

## Common Mistakes & Fixes

### ❌ Mistake 1: Wrong Base Case
```java
// WRONG
public static int wrong(int n) {
    if (n == 1) return 1;  // Base case at 1
    return n + wrong(n - 1);
}

wrong(4);  // returns 4 + 3 + 2 + 1 = 10 ✓ (works by luck!)
wrong(0);  // returns nothing! ✗ (assumes n >= 1)
```

**Fix:**
```java
// RIGHT
public static int correct(int n) {
    if (n == 0) return 0;  // Base case at 0
    return n + correct(n - 1);
}

correct(4);  // 10 ✓
correct(0);  // 0 ✓
```

### ❌ Mistake 2: Not Returning Result
```java
// WRONG
public static int wrong(int n) {
    if (n == 0) return 0;
    wrong(n - 1);              // Result lost! ✗
    return n;                  // Only returns n
}

wrong(5);  // returns 5 (not 15) ✗
```

**Fix:**
```java
// RIGHT
public static int correct(int n) {
    if (n == 0) return 0;
    return n + correct(n - 1);  // ✓ Combine results
}

correct(5);  // 15 ✓
```

### ❌ Mistake 3: Infinite Recursion
```java
// WRONG
public static int wrong(int n) {
    if (n == 0) return 0;
    return n + wrong(n);  // n doesn't decrease!
}

wrong(5);  // StackOverflowError ❌
```

**Fix:**
```java
// RIGHT
public static int correct(int n) {
    if (n == 0) return 0;
    return n + correct(n - 1);  // ✓ n decreases
}

correct(5);  // 15 ✓
```

### ❌ Mistake 4: Off-by-One
```java
// WRONG
public static int wrong(int n) {
    if (n <= 0) return 0;  // Can be OK
    return (n - 1) + wrong(n - 1);  // Adding n-1 instead of n!
}

wrong(5);  // Returns 4 + 3 + 2 + 1 = 10 (not 15) ✗
```

**Fix:**
```java
// RIGHT
public static int correct(int n) {
    if (n == 0) return 0;
    return n + correct(n - 1);  // ✓ Add n, not n-1
}

correct(5);  // 15 ✓
```

---

## Test Cases

### Test 1: Basic Cases
```java
System.out.println(sumOfNNumbers(0));   // 0
System.out.println(sumOfNNumbers(1));   // 1
System.out.println(sumOfNNumbers(2));   // 3 (1+2)
System.out.println(sumOfNNumbers(3));   // 6 (1+2+3)
System.out.println(sumOfNNumbers(4));   // 10 (1+2+3+4)
System.out.println(sumOfNNumbers(5));   // 15 (1+2+3+4+5)
```

### Test 2: Larger Numbers
```java
System.out.println(sumOfNNumbers(10));   // 55
System.out.println(sumOfNNumbers(100));  // 5050
System.out.println(sumOfNNumbers(1000)); // 500500
```

### Verify with Formula
```java
// Check: n*(n+1)/2
// n=10: 10*11/2 = 55 ✓
// n=100: 100*101/2 = 5050 ✓
// n=1000: 1000*1001/2 = 500500 ✓
```

---

## Key Patterns Learned

### Pattern 1: Return Value Recursion
```
Problem: Compute something from smaller subproblems

Pattern:
if (base case) return base_value;
return current_value OP recursive_result;

Examples:
- sum(n) = n + sum(n-1)
- factorial(n) = n * factorial(n-1)
- power(n) = base * power(n-1)
```

### Pattern 2: Combining Results
```
Key idea: Don't just return recursion result
Combine it with current work:

❌ wrong(n) = wrong(n-1)          // Lost work!
✓ right(n) = work + right(n-1)    // Combined!
```

---

## Key Takeaways

✅ **What We Learned:**
1. How to RETURN values from recursion
2. How to COMBINE current work with recursive result
3. Importance of choosing correct base case
4. Time/Space complexity for recursive problems
5. Alternatives: iteration and formula

✅ **When to Use:**
- Any cumulative calculation (sum, product, count)
- Dynamic programming (with memoization)
- Building up results during backtracking

✅ **Real-World Applications:**
- Calculating totals and aggregates
- Tree node counting
- Recursive list processing

---

## Summary

| Aspect | Details |
|--------|---------|
| **Problem** | Sum of 1 to N |
| **Formula** | sum(n) = n + sum(n-1) |
| **Base Case** | n == 0 → return 0 |
| **Recursive** | return n + sumOfNNumbers(n-1) |
| **Time** | O(n) |
| **Space** | O(n) |
| **Best Alt** | Formula: n*(n+1)/2 → O(1) |
| **Difficulty** | ⭐⭐ Intermediate |

---

**Next Problem:** Factorial → Problem4_Factorial
