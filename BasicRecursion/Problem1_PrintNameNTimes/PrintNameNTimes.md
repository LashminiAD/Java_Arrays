# Problem 1: Print Name N Times

## Problem Statement
Print a name (e.g., "Lashmini") **n times** using recursion. You must not use any loops.

**Examples:**
- Input: n = 5 → Output: Print "Lashmini" 5 times
- Input: n = 3 → Output: Print "Lashmini" 3 times
- Input: n = 0 → Output: (no output)

---

## Understanding the Problem

### What We Need to Do:
```
n = 5:
Print: Lashmini
Print: Lashmini
Print: Lashmini
Print: Lashmini
Print: Lashmini
(Total: 5 times)
```

### Why Use Recursion?
- **Natural**: Repeating the same task n times fits recursion perfectly
- **Simple**: No loop complexity needed
- **Educational**: Perfect first recursion problem!

---

## Solution Explanation

### Complete Code
```java
static void printName(int n) {
    // BASE CASE: when to stop
    if (n == 0) {
        return;
    }
    
    // WORK: print the name
    System.out.println("Lashmini");
    
    // RECURSIVE CALL: reduce problem
    printName(n - 1);
}
```

### The 3 Parts Explained

#### Part 1: BASE CASE
```java
if (n == 0) {
    return;
}
```
- **What it does**: Stops the recursion
- **Why needed**: Without it, infinite loop! 
- **When triggered**: When n becomes 0
- **Result**: Function returns, no more calls

#### Part 2: WORK
```java
System.out.println("Lashmini");
```
- **What it does**: Prints the name ONCE
- **When happens**: Before making recursive call
- **Result**: Prints during forward phase (going down stack)
- **Important**: Gets executed for EACH call

#### Part 3: RECURSIVE CALL
```java
printName(n - 1);
```
- **What it does**: Calls itself with smaller problem
- **Why**: n-1 is closer to base case (0)
- **Progress**: Each call gets closer to stopping
- **Result**: Builds the call stack

---

## Execution Flow (for n = 3)

### Step-by-Step:

```
STEP 1: printName(3) called
├─ n = 3, not 0, so continue
├─ print "Lashmini"
└─ call printName(2)

STEP 2: printName(2) called
├─ n = 2, not 0, so continue
├─ print "Lashmini"
└─ call printName(1)

STEP 3: printName(1) called
├─ n = 1, not 0, so continue
├─ print "Lashmini"
└─ call printName(0)

STEP 4: printName(0) called
├─ n = 0, BASE CASE!
└─ return (no more calls)

STEP 5: Back to printName(1)
└─ return (complete)

STEP 6: Back to printName(2)
└─ return (complete)

STEP 7: Back to printName(3)
└─ return (complete)

DONE!
```

### Call Stack Visualization

```
TIME:  0           1           2           3           4      5      6

       print(3)
       ├print(2)
       │ ├print(1)
       │ │ ├print(0) ← PEAK (4 frames)
       │ │ │ └BASE CASE
       │ │ └return
       │ └return
       └return

PRINTING happens during FORWARD phase (steps 1-3):
Output: Lashmini (from print(3))
        Lashmini (from print(2))
        Lashmini (from print(1))
        (print(0) doesn't print)
```

### Complete Output (for n = 5)

```
Lashmini
Lashmini
Lashmini
Lashmini
Lashmini
```

---

## How It Works

### Forward Phase (Building Stack)
```
printName(5) calls printName(4)
  └─ printName(4) calls printName(3)
      └─ printName(3) calls printName(2)
          └─ printName(2) calls printName(1)
              └─ printName(1) calls printName(0)
                  └─ printName(0) → BASE CASE
```

Each call:
1. ✓ Print "Lashmini" once
2. ✓ Add frame to stack
3. ✓ Call self with n-1

### Backward Phase (Unwinding Stack)
```
printName(0) returns ← Stop
printName(1) returns ← Return
printName(2) returns ← Return
printName(3) returns ← Return
printName(4) returns ← Return
printName(5) returns ← Return
```

All frames pop from stack as function finishes.

---

## Why This Works

### Check the 3 Requirements:

| Requirement | Status | Explanation |
|-------------|--------|-------------|
| **Base Case** | ✓ YES | `if (n == 0) return;` |
| **Recursive Case** | ✓ YES | `printName(n - 1);` |
| **Progress** | ✓ YES | n decreases by 1 each time |

### Prevents Stack Overflow:
- Each call has n-1
- Eventually n becomes 0
- Base case stops recursion
- Stack doesn't grow infinitely!

---

## Complexity Analysis

### Time Complexity: O(n)
```
printName(5) calls: 6 function calls total
  printName(5)
  printName(4)
  printName(3)
  printName(2)
  printName(1)
  printName(0)

Each call does O(1) work (one println)
Total: 6 × O(1) = O(n)
```

### Space Complexity: O(n)
```
Call stack depth for printName(n):
- printName(n) on stack
- printName(n-1) on stack
- printName(n-2) on stack
- ...
- printName(0) on stack

Maximum depth: n+1 frames
Each frame: ~50-100 bytes
Total: ~(n+1) × 100 bytes ≈ O(n)
```

### Memory Usage Example
```
printName(5):
├─ Stack frames: 6
├─ Memory per frame: ~100 bytes
└─ Total: ~600 bytes ✓ (tiny)

printName(1000):
├─ Stack frames: 1001
├─ Memory per frame: ~100 bytes
└─ Total: ~100 KB ✓ (acceptable)

printName(50000):
├─ Stack frames: 50001
├─ Memory per frame: ~100 bytes
└─ Total: ~5 MB ✗ (may exceed stack limit)
```

---

## Alternative: Iterative Solution

### Iteration (Simpler & Safer)
```java
static void printNameIterative(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println("Lashmini");
    }
}

// Same output, no recursion!
// Better for large n (avoids stack overflow)
```

### Comparison

| Aspect | Recursive | Iterative |
|--------|-----------|-----------|
| Time | O(n) | O(n) |
| Space | O(n) | O(1) |
| Safety | Risky for large n | Always safe |
| Clarity | Elegant | Simple |

---

## Common Mistakes & Fixes

### ❌ Mistake 1: No Base Case
```java
// WRONG
static void wrong(int n) {
    System.out.println("Lashmini");
    wrong(n - 1);  // No base case!
}

// Result: StackOverflowError ❌
```

**Fix:**
```java
// RIGHT
static void correct(int n) {
    if (n == 0) return;        // ✓ Add base case
    System.out.println("Lashmini");
    correct(n - 1);
}
```

### ❌ Mistake 2: Not Decreasing n
```java
// WRONG
static void wrong(int n) {
    if (n == 0) return;
    System.out.println("Lashmini");
    wrong(n);  // n doesn't change!
}

// Result: StackOverflowError ❌
```

**Fix:**
```java
// RIGHT
static void correct(int n) {
    if (n == 0) return;
    System.out.println("Lashmini");
    correct(n - 1);  // ✓ Decrease n
}
```

### ❌ Mistake 3: Print After Recursion
```java
// WRONG (but technically works)
static void wrong(int n) {
    if (n == 0) return;
    wrong(n - 1);              // Call first
    System.out.println("Lashmini");  // Print after
}

// Output: Still prints n times, but in REVERSE order
// For n=3: Lashmini, Lashmini, Lashmini (same result by chance)
```

**Better:**
```java
// RIGHT
static void correct(int n) {
    if (n == 0) return;
    System.out.println("Lashmini");  // Print BEFORE
    correct(n - 1);
}

// More intuitive: print first, then recurse
```

---

## Test Cases

### Test 1: Basic Case
```java
printName(5);
// Output:
// Lashmini
// Lashmini
// Lashmini
// Lashmini
// Lashmini
```

### Test 2: Single Print
```java
printName(1);
// Output:
// Lashmini
```

### Test 3: No Print
```java
printName(0);
// Output:
// (nothing - no output)
```

### Test 4: Larger Number
```java
printName(10);
// Output: 10 lines of "Lashmini"
```

### Test 5: Very Large (Safe Limit)
```java
printName(5000);
// Output: 5000 lines of "Lashmini" ✓ (works)

printName(50000);
// May cause StackOverflowError ✗ (too deep)
```

---

## Key Takeaways

✅ **What We Learned:**
1. Basic recursion structure: base case → work → recursive call
2. How call stack builds and unwinds
3. Importance of base case to prevent infinite loops
4. Progress requirement: each call must move closer to base case
5. Space complexity grows with n

✅ **When to Use This Pattern:**
- Repeating same task n times
- Simple recursion problems
- When n is reasonably small

✅ **Optimization Tips:**
- For large n, use iteration instead
- Avoid deep recursion (> 10,000) on stack-limited systems
- Consider tail recursion optimization

---

## Summary

| Aspect | Details |
|--------|---------|
| **Problem** | Print name n times |
| **Approach** | Recursion |
| **Base Case** | n == 0 |
| **Recursive Call** | printName(n - 1) |
| **Time** | O(n) |
| **Space** | O(n) |
| **Difficulty** | ⭐ Beginner |

---

**Next Problem:** Print 1 to N (different order!) → Problem2_Print1ToN
