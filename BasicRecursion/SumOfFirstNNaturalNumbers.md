# Sum of First N Natural Numbers - Recursion Problem

## Problem Statement
Given integer N, return sum of first N natural numbers using recursion.

Examples:
- N = 4 → 1 + 2 + 3 + 4 = 10
- N = 5 → 1 + 2 + 3 + 4 + 5 = 15

## Solution Code
```java
public static int sumOfNNumbers(int n) {
    if (n == 0) return 0;           // Base case
    return n + sumOfNNumbers(n - 1); // Recursive relation
}
```

## Mathematical Formula
```
sum(n) = n + sum(n-1)

Example: sum(4)
= 4 + sum(3)
= 4 + (3 + sum(2))
= 4 + (3 + (2 + sum(1)))
= 4 + (3 + (2 + (1 + sum(0))))
= 4 + (3 + (2 + (1 + 0)))
= 4 + 3 + 2 + 1 + 0
= 10
```

## How It Works

### Execution Flow (n = 4)
```
sumOfNNumbers(4)
  → return 4 + sumOfNNumbers(3)
    → return 3 + sumOfNNumbers(2)
      → return 2 + sumOfNNumbers(1)
        → return 1 + sumOfNNumbers(0)
          → return 0
        ← return 1 + 0 = 1
      ← return 2 + 1 = 3
    ← return 3 + 3 = 6
  ← return 4 + 6 = 10
```

## Call Stack Visualization

```
Depth 4: sum(4) waiting for sum(3)
Depth 3: sum(3) waiting for sum(2)
Depth 2: sum(2) waiting for sum(1)
Depth 1: sum(1) waiting for sum(0)
Depth 0: sum(0) → return 0

Unwinding (Computing):
Depth 1: 1 + 0 = 1
Depth 2: 2 + 1 = 3
Depth 3: 3 + 3 = 6
Depth 4: 4 + 6 = 10
```

## Complexity Analysis

| Metric | Value | Reason |
|--------|-------|--------|
| Time Complexity | O(n) | n recursive calls |
| Space Complexity | O(n) | Call stack depth is n |

## Alternative Approaches

### 1. Iterative Solution (Better Space)
```java
public static int sumIterative(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i;
    }
    return sum;
}
```
**Time**: O(n) | **Space**: O(1) ✓

### 2. Mathematical Formula (Best)
```java
public static int sumFormula(int n) {
    return n * (n + 1) / 2;
}
```
**Time**: O(1) | **Space**: O(1) ✓✓

## Comparison

| Approach | Time | Space | Pros | Cons |
|----------|------|-------|------|------|
| Recursion | O(n) | O(n) | Easy to understand | Stack overflow risk |
| Iterative | O(n) | O(1) | Better space | Slightly verbose |
| Formula | O(1) | O(1) | Optimal | Needs math knowledge |

## Example Test Cases

**Test 1: n = 4**
```
Output: 10
Explanation: 1 + 2 + 3 + 4 = 10
```

**Test 2: n = 5**
```
Output: 15
Explanation: 1 + 2 + 3 + 4 + 5 = 15
```

**Test 3: n = 0**
```
Output: 0
Explanation: No numbers to sum
```

## Key Insights
- Always return the recursive call result
- Think in terms of f(n) = n + f(n-1)
- Consider alternatives for production code