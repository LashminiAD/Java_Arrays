# Problem 2: Print 1 to N

## Problem Statement
Print all numbers from **1 to N** in **increasing order** using recursion. You must not use any loops.

**Examples:**
- Input: n = 5 → Output: 1 2 3 4 5
- Input: n = 3 → Output: 1 2 3
- Input: n = 1 → Output: 1
- Input: n = 0 → Output: (no output)

---

## Understanding the Problem

### What We Need to Do:
```
n = 5:
Print: 1
Print: 2
Print: 3
Print: 4
Print: 5
(In INCREASING order, not decreasing!)
```

### The Challenge:
**How to print in increasing order using recursion?**

Without recursion (loop):
```java
for (int i = 1; i <= n; i++) {
    System.out.println(i);  // Easy: print before recursing
}
```

With recursion:
```
If we print before recursion:
  printNumbers(5) → print 5, call printNumbers(4)
    → print 4, call printNumbers(3)
      → ... 
  Result: 5, 4, 3, 2, 1 ✗ (WRONG ORDER!)
```

**Solution: Print AFTER recursion!** ✓

---

## Solution Explanation

### Complete Code
```java
public static void printNumbers(int n) {
    // BASE CASE
    if (n == 0) {
        return;
    }
    
    // RECURSIVE CALL FIRST
    printNumbers(n - 1);
    
    // PRINT AFTER (This is the KEY!)
    System.out.println(n);
}
```

### Key Insight: Print Before vs After

#### ❌ Print BEFORE Recursion (Decreasing Order)
```java
void printBefore(int n) {
    if (n == 0) return;
    System.out.println(n);      // Print FIRST
    printBefore(n - 1);
}

// For n=3:
// Execution: print 3 → print 2 → print 1
// Output: 3, 2, 1 (DECREASING) ✗
```

#### ✅ Print AFTER Recursion (Increasing Order)
```java
void printAfter(int n) {
    if (n == 0) return;
    printAfter(n - 1);
    System.out.println(n);      // Print AFTER
}

// For n=3:
// Execution: recurse → recurse → base case → print 1 → print 2 → print 3
// Output: 1, 2, 3 (INCREASING) ✓
```

### 💡 Memory Trick:
```
Print BEFORE recursion → Numbers go DOWN (N to 1) ⬇️
Print AFTER recursion  → Numbers go UP (1 to N) ⬆️
```

---

## Execution Flow (for n = 3)

### Forward Phase (Going Down)
```
printNumbers(3) called
  ├─ n = 3, not 0
  ├─ call printNumbers(2)  (DON'T PRINT YET!)
      ├─ n = 2, not 0
      ├─ call printNumbers(1)  (DON'T PRINT YET!)
          ├─ n = 1, not 0
          ├─ call printNumbers(0)  (DON'T PRINT YET!)
              └─ n = 0, BASE CASE → return
```

### Backward Phase (Coming Back Up) - NOW WE PRINT!
```
Back to printNumbers(1):
  ├─ Print 1 ← First print!
  
Back to printNumbers(2):
  ├─ Print 2 ← Second print
  
Back to printNumbers(3):
  ├─ Print 3 ← Third print
```

### Call Stack Visualization

```
FORWARD (Building Stack):
┌─────────────────┐
│ printNumbers(0) │ ← BASE CASE (depth 4)
│ printNumbers(1) │
│ printNumbers(2) │
│ printNumbers(3) │ ← Main call (depth 1)
└─────────────────┘

BACKWARD (Unwinding + Printing):
printNumbers(0) returns (no print)
  ↓
printNumbers(1) returns: Print 1
  ↓
printNumbers(2) returns: Print 2
  ↓
printNumbers(3) returns: Print 3
```

### Timeline

```
Step 1: printNumbers(3)
        → doesn't print yet
        → calls printNumbers(2)

Step 2: printNumbers(2)
        → doesn't print yet
        → calls printNumbers(1)

Step 3: printNumbers(1)
        → doesn't print yet
        → calls printNumbers(0)

Step 4: printNumbers(0)
        → BASE CASE, returns

Step 5: Back in printNumbers(1)
        → NOW PRINT: 1
        → returns

Step 6: Back in printNumbers(2)
        → NOW PRINT: 2
        → returns

Step 7: Back in printNumbers(3)
        → NOW PRINT: 3
        → returns

OUTPUT: 1, 2, 3 ✓
```

### Complete Output (for n = 5)

```
1
2
3
4
5
```

---

## How It Works (The Magic!)

### Why Printing After Works:

When we print AFTER recursion:
1. We first reach the base case (smallest value)
2. Then we UNWIND the stack
3. Each unwinding step prints ONE number
4. Unwinding goes from bottom to top of stack
5. Bottom of stack = smallest recursion level = LOWEST value
6. Top of stack = largest recursion level = HIGHEST value

```
Stack Layout (for n=5):

Top:    printNumbers(5) ← Print 5 (last)
        printNumbers(4) ← Print 4
        printNumbers(3) ← Print 3
        printNumbers(2) ← Print 2
Bottom: printNumbers(1) ← Print 1 (first)

Unwinding order: Bottom → Top = 1 → 5 ✓
```

---

## Complexity Analysis

### Time Complexity: O(n)
```
For printNumbers(5):
- printNumbers(5) → calls printNumbers(4)
- printNumbers(4) → calls printNumbers(3)
- printNumbers(3) → calls printNumbers(2)
- printNumbers(2) → calls printNumbers(1)
- printNumbers(1) → calls printNumbers(0)
- printNumbers(0) → BASE CASE

Total calls: 6 function calls
Each call: O(1) work (one println)
Total: 6 × O(1) = O(n) ✓
```

### Space Complexity: O(n)
```
Stack depth for printNumbers(n):

printNumbers(5)
  ├─ printNumbers(4)
  │   ├─ printNumbers(3)
  │   │   ├─ printNumbers(2)
  │   │   │   ├─ printNumbers(1)
  │   │   │   │   └─ printNumbers(0)

Maximum depth: n + 1 = 6 frames
Each frame: ~100 bytes
Total: ~600 bytes = O(n) ✓
```

---

## Alternative: Compare Print Order

### Approach 1: Print Before (Decreasing)
```java
void printDecreasing(int n) {
    if (n == 0) return;
    System.out.println(n);      // Print BEFORE
    printDecreasing(n - 1);
}

printDecreasing(5);
// Output: 5, 4, 3, 2, 1
```

### Approach 2: Print After (Increasing)
```java
void printIncreasing(int n) {
    if (n == 0) return;
    printIncreasing(n - 1);
    System.out.println(n);      // Print AFTER
}

printIncreasing(5);
// Output: 1, 2, 3, 4, 5
```

### Approach 3: Iterative (Simplest)
```java
void printIterative(int n) {
    for (int i = 1; i <= n; i++) {
        System.out.println(i);
    }
}

printIterative(5);
// Output: 1, 2, 3, 4, 5
```

| Approach | Order | Complexity | Clarity |
|----------|-------|-----------|---------|
| Print Before | Decreasing | O(n) time, O(n) space | Easy |
| Print After | Increasing | O(n) time, O(n) space | Tricky |
| Iterative | Increasing | O(n) time, O(1) space | Best |

---

## Common Mistakes & Fixes

### ❌ Mistake 1: No Base Case
```java
// WRONG
static void wrong(int n) {
    printNumbers(n - 1);
    System.out.println(n);  // No base case!
}

// Result: StackOverflowError ❌
```

**Fix:**
```java
// RIGHT
static void correct(int n) {
    if (n == 0) return;        // ✓ Add base case
    correct(n - 1);
    System.out.println(n);
}
```

### ❌ Mistake 2: Print Before (Wrong Order)
```java
// WRONG (if goal is 1 to N)
static void wrong(int n) {
    if (n == 0) return;
    System.out.println(n);     // Print BEFORE
    wrong(n - 1);
}

// For n=3: Output 3, 2, 1 ✗ (not 1, 2, 3)
```

**Fix:**
```java
// RIGHT
static void correct(int n) {
    if (n == 0) return;
    correct(n - 1);
    System.out.println(n);     // ✓ Print AFTER
}

// For n=3: Output 1, 2, 3 ✓
```

### ❌ Mistake 3: Not Returning After Print
```java
// WORKS but unclear
static void unclear(int n) {
    if (n == 0) return;
    unclear(n - 1);
    System.out.println(n);
    // Returns implicitly (OK, but confusing)
}

// Actually works, but better to be explicit
```

**Better:**
```java
// CLEARER
static void clear(int n) {
    if (n == 0) return;
    clear(n - 1);
    System.out.println(n);
    return;  // Explicit return (optional but clearer)
}
```

---

## Test Cases

### Test 1: Basic Case
```java
printNumbers(5);
// Output:
// 1
// 2
// 3
// 4
// 5
```

### Test 2: Single Number
```java
printNumbers(1);
// Output:
// 1
```

### Test 3: Zero
```java
printNumbers(0);
// Output:
// (nothing - no output)
```

### Test 4: Small Range
```java
printNumbers(3);
// Output:
// 1
// 2
// 3
```

### Test 5: Larger Number
```java
printNumbers(100);
// Output:
// 1
// 2
// ...
// 100
```

---

## Key Differences from Problem 1

| Aspect | Problem 1 | Problem 2 |
|--------|-----------|-----------|
| **Task** | Print same name n times | Print 1 to n |
| **What to vary** | Just repeat same | Vary the number |
| **Print timing** | BEFORE recursion | AFTER recursion |
| **Output order** | All same | Ascending order |
| **Difficulty** | ⭐⭐ Easy | ⭐⭐⭐ Medium |

---

## Key Takeaways

✅ **What We Learned:**
1. Print order depends on WHEN we print (before vs after recursion)
2. Print BEFORE = descending order (N to 1)
3. Print AFTER = ascending order (1 to N)
4. Backtracking phase is when unwinding happens
5. Understanding call stack is crucial

✅ **When to Use This Pattern:**
- Printing ranges in specific order
- Understanding forward and backward phases
- Mastering recursion flow

✅ **Real-World Applications:**
- Tree traversal (in-order, post-order)
- Undo operations (process in reverse)
- Backtracking algorithms

---

## Summary

| Aspect | Details |
|--------|---------|
| **Problem** | Print 1 to N |
| **Key Insight** | Print AFTER recursion for increasing order |
| **Base Case** | n == 0 |
| **Recursive Call** | printNumbers(n - 1) |
| **Time** | O(n) |
| **Space** | O(n) |
| **Difficulty** | ⭐⭐ Intermediate |

---

**Next Problem:** Sum of N Numbers → Problem3_SumOfNNumbers
