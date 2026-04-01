# Problem 4: Factorial

## Problem Statement
Find the **factorial of N** using recursion.

**Factorial Definition:**
- 0! = 1 (by definition)
- 1! = 1
- n! = n × (n-1) × (n-2) × ... × 2 × 1

**Examples:**
- Input: 5 → Output: 120 (5 × 4 × 3 × 2 × 1)
- Input: 4 → Output: 24 (4 × 3 × 2 × 1)
- Input: 0 → Output: 1 (by definition)
- Input: 1 → Output: 1

---

## Understanding the Problem

### What is Factorial?
```
5! = 5 × 4 × 3 × 2 × 1 = 120

Visual:
5! = 5 × 4!
4! = 4 × 3!
3! = 3 × 2!
2! = 2 × 1!
1! = 1 (base case)
```

### Why Use Recursion?
- **Natural definition**: n! = n × (n-1)!
- **Perfect fit**: The problem IS defined recursively
- **Mathematical**: Classic recursion example

### Key Insight:
```
factorial(n) = n × factorial(n-1)

This IS a recursive definition!
```

---

## Solution Explanation

### Complete Code
```java
public static int factorial(int n) {
    // BASE CASE
    if (n <= 1) {
        return 1;
    }
    
    // RECURSIVE CASE
    return n * factorial(n - 1);
}
```

### The Pattern: f(n) = n × f(n-1)

Similar to sum, but with MULTIPLICATION instead of addition.

---

## Step-by-Step Example: factorial(5)

### Execution Trace

```
CALL 1: factorial(5)
  ├─ n = 5, not <= 1
  └─ return 5 * factorial(4)
     Waits for factorial(4)...

CALL 2: factorial(4)
  ├─ n = 4, not <= 1
  └─ return 4 * factorial(3)
     Waits for factorial(3)...

CALL 3: factorial(3)
  ├─ n = 3, not <= 1
  └─ return 3 * factorial(2)
     Waits for factorial(2)...

CALL 4: factorial(2)
  ├─ n = 2, not <= 1
  └─ return 2 * factorial(1)
     Waits for factorial(1)...

CALL 5: factorial(1)
  ├─ n = 1, n <= 1 (BASE CASE!)
  └─ return 1 ✓

UNWINDING (building result):
factorial(1) returns: 1
factorial(2) returns: 2 * 1 = 2
factorial(3) returns: 3 * 2 = 6
factorial(4) returns: 4 * 6 = 24
factorial(5) returns: 5 * 24 = 120 ✓
```

### Mathematical Breakdown

```
factorial(5) = 5 × factorial(4)
             = 5 × (4 × factorial(3))
             = 5 × (4 × (3 × factorial(2)))
             = 5 × (4 × (3 × (2 × factorial(1))))
             = 5 × (4 × (3 × (2 × 1)))
             = 5 × (4 × (3 × 2))
             = 5 × (4 × 6)
             = 5 × 24
             = 120 ✓
```

### Call Stack Visualization

```
BUILDING STACK (Forward):
┌──────────────────────┐
│ factorial(1) = 1     │ ← Base case (depth 5)
│ factorial(2) = ?     │
│ factorial(3) = ?     │
│ factorial(4) = ?     │
│ factorial(5) = ?     │ ← Main call (depth 1)
└──────────────────────┘

UNWINDING STACK (Backward):
factorial(1):
  returns 1

factorial(2):
  gets 1 from above
  calculates 2 × 1 = 2
  returns 2

factorial(3):
  gets 2 from above
  calculates 3 × 2 = 6
  returns 6

factorial(4):
  gets 6 from above
  calculates 4 × 6 = 24
  returns 24

factorial(5):
  gets 24 from above
  calculates 5 × 24 = 120
  returns 120 ✓ FINAL RESULT
```

---

## Key Differences from Sum

### Sum vs Factorial

| Aspect | Sum | Factorial |
|--------|-----|-----------|
| **Formula** | f(n) = n + f(n-1) | f(n) = n × f(n-1) |
| **Operation** | Addition | Multiplication |
| **Base Value** | 0 | 1 |
| **Result** | Linear growth | Exponential growth |

### Why Different Base Cases?

**Sum needs 0:**
```java
if (n == 0) return 0;
return n + sum(n-1);

Why? Adding 0 doesn't change sum
0 is identity element for addition
```

**Factorial needs 1:**
```java
if (n <= 1) return 1;
return n * factorial(n-1);

Why? Multiplying by 1 doesn't change product
1 is identity element for multiplication
```

---

## Complexity Analysis

### Time Complexity: O(n)
```
For factorial(5):
- factorial(5)
- factorial(4)
- factorial(3)
- factorial(2)
- factorial(1)

Total: 5 calls (which is n)
Each does O(1) work: one multiplication, one return
Total: n × O(1) = O(n) ✓
```

### Space Complexity: O(n)
```
Call stack depth for factorial(n):

factorial(5)
  ├─ factorial(4)
  │   ├─ factorial(3)
  │   │   ├─ factorial(2)
  │   │   │   └─ factorial(1)

Maximum depth: n = 5
Each frame: ~100 bytes
Total: ~500 bytes = O(n) ✓
```

---

## Important Limitations

### ⚠️ Integer Overflow

Factorial grows VERY FAST!

```
0! = 1
1! = 1
2! = 2
3! = 6
4! = 24
5! = 120
10! = 3,628,800
15! = 1,307,674,368,000
20! = 2,432,902,008,176,640,000 (too large for long!)
21! = overflow!
```

### Solution: Use Long

```java
public static long factorialLong(int n) {
    if (n <= 1) return 1;
    return n * factorialLong(n - 1);
}

factorialLong(20);  // 2432902008176640000 ✓
factorialLong(21);  // Overflow! ❌
```

### Better Solution: Use BigInteger

```java
import java.math.BigInteger;

public static BigInteger factorialBig(int n) {
    if (n <= 1) return BigInteger.ONE;
    return BigInteger.valueOf(n)
           .multiply(factorialBig(n - 1));
}

factorialBig(50);   // Works! ✓
factorialBig(100);  // Works! ✓
```

---

## Alternative Solutions

### Solution 1: Iterative
```java
public static int factorialIterative(int n) {
    int result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}

factorialIterative(5);  // 120

// Time: O(n) (same)
// Space: O(1) (better!)
```

### Solution 2: Tail Recursion
```java
public static int factorialTail(int n, int accumulator) {
    if (n <= 1) {
        return accumulator;
    }
    return factorialTail(n - 1, n * accumulator);
}

// Call: factorialTail(5, 1)
// Result: 120

// Can be optimized by compiler (tail call optimization)
// Java doesn't optimize, but concept is important
```

### Comparison

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Recursion | O(n) | O(n) | Elegant but risky |
| Iterative | O(n) | O(1) | Best for production |
| Tail Recursion | O(n) | O(1) | Compiler-optimized (not Java) |
| BigInteger | O(n²) | O(n) | For large factorials |

---

## Common Mistakes & Fixes

### ❌ Mistake 1: Wrong Base Case
```java
// WRONG
public static int wrong(int n) {
    if (n == 0) return 0;  // Should be 1!
    return n * wrong(n - 1);
}

wrong(5);  // returns 0 (wrong!) ✗
```

**Why?** 
```
factorial(1) = 1 × factorial(0) = 1 × 0 = 0 ✗
Should be: factorial(0) = 1
```

**Fix:**
```java
// RIGHT
public static int correct(int n) {
    if (n <= 1) return 1;  // ✓ Base case
    return n * correct(n - 1);
}

correct(5);  // 120 ✓
```

### ❌ Mistake 2: Missing Multiplication
```java
// WRONG
public static int wrong(int n) {
    if (n <= 1) return 1;
    wrong(n - 1);           // Recursion not used!
    return n;               // Only returns n
}

wrong(5);  // returns 5 (not 120) ✗
```

**Fix:**
```java
// RIGHT
public static int correct(int n) {
    if (n <= 1) return 1;
    return n * correct(n - 1);  // ✓ Multiply result
}

correct(5);  // 120 ✓
```

### ❌ Mistake 3: Overflow
```java
// WRONG (for large n)
public static int wrong(int n) {
    if (n <= 1) return 1;
    return n * wrong(n - 1);
}

wrong(21);  // Integer overflow! ✗
```

**Fix:**
```java
// Use long instead
public static long correct(int n) {
    if (n <= 1) return 1;
    return n * correct(n - 1);
}

correct(20);  // 2432902008176640000 ✓
correct(21);  // Still overflows (too large for long)

// Or use BigInteger
public static BigInteger correctBig(int n) {
    if (n <= 1) return BigInteger.ONE;
    return BigInteger.valueOf(n)
           .multiply(correctBig(n - 1));
}

correctBig(50);  // ✓ Works!
```

### ❌ Mistake 4: Stack Overflow
```java
// WRONG
public static int wrong(int n) {
    if (n <= 1) return 1;
    return n * wrong(n - 1);
}

wrong(50000);  // StackOverflowError! ❌
```

**Why?** Stack depth = 50000, exceeds limit

**Fix:**
```java
// Use iterative approach
public static long correct(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}

correct(50000);  // ✓ No stack issue
```

---

## Test Cases

### Test 1: Base Cases
```java
System.out.println(factorial(0));   // 1 (by def)
System.out.println(factorial(1));   // 1
System.out.println(factorial(2));   // 2
System.out.println(factorial(3));   // 6
```

### Test 2: Standard Cases
```java
System.out.println(factorial(4));   // 24
System.out.println(factorial(5));   // 120
System.out.println(factorial(10));  // 3628800
```

### Test 3: Verify
```java
// Verify manually:
// 5! = 5 × 4 × 3 × 2 × 1 = 120 ✓
// 4! = 4 × 3 × 2 × 1 = 24 ✓
// 3! = 3 × 2 × 1 = 6 ✓
// 2! = 2 × 1 = 2 ✓
// 1! = 1 ✓
// 0! = 1 ✓
```

---

## Key Patterns Learned

### Pattern: Multiplicative Recursion
```
General form: f(n) = n × f(n-1)

Examples using this pattern:
- factorial(n) = n × factorial(n-1)
- countPermutations(n) = n × countPermutations(n-1)
- power(base, n) = base × power(base, n-1)
```

---

## Key Takeaways

✅ **What We Learned:**
1. Mathematical recursion: n! = n × (n-1)!
2. Base case for multiplication: 1 (identity)
3. How multiplication builds up results
4. Importance of using appropriate data types (int vs long vs BigInteger)
5. Stack overflow risk for large inputs

✅ **When to Use:**
- Classic recursion teaching example
- Permutations and combinations
- Any multiplicative pattern

✅ **Real-World Considerations:**
- Use iterative for production code
- Be aware of overflow
- Consider performance
- Use BigInteger for very large values

---

## Summary

| Aspect | Details |
|--------|---------|
| **Problem** | Calculate factorial of N |
| **Formula** | n! = n × (n-1)! |
| **Base Case** | n <= 1 → return 1 |
| **Recursive** | return n * factorial(n-1) |
| **Time** | O(n) |
| **Space** | O(n) |
| **Limitation** | Integer overflow for n > 12 |
| **Difficulty** | ⭐⭐ Intermediate |

---

**Next Problem:** Reverse Array → Problem5_ReverseArray
