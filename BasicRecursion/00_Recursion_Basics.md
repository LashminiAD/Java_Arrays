# 🚀 RECURSION BASICS - Complete Guide

## What is Recursion?

**Recursion** is when a function calls itself directly or indirectly.

**Simple Definition:** A problem-solving technique where a function solves a problem by breaking it into smaller similar sub-problems.

### Real-World Example
**Finding a book in a library:**
```
To find a book:
  1. Check current shelf
  2. If found → Return it ✓
  3. If not found → Check next shelf (repeat)

```

### Key Requirement for Recursion
Every recursion MUST have:
1. **Base Case** - When to STOP
2. **Recursive Case** - How to reduce the problem
3. **Progress toward Base Case** - Each call must get closer

---

## How Does Recursion Work?

### The 3 Essential Parts

```java
// TEMPLATE
void recursiveFunction(int n) {
    // PART 1: BASE CASE (when to stop)
    if (n == 0) {
        return;
    }
    
    // PART 2: WORK (what to do)
    System.out.println(n);
    
    // PART 3: RECURSIVE CALL (reduce problem)
    recursiveFunction(n - 1);
}
```

### Example: Print 5, 4, 3, 2, 1

```java
void printNumbers(int n) {
    if (n == 0) {              // BASE CASE
        return;
    }
    
    System.out.println(n);     // WORK
    printNumbers(n - 1);       // RECURSIVE CALL
}

// Call: printNumbers(5)
// Output: 5 → 4 → 3 → 2 → 1
```

---

## Understanding Call Stack

### What is Call Stack?
The call stack is **memory that stores information about function calls**.

Each time a function is called:
- A new **frame** is added to the stack
- When it returns, the frame is removed

### Visualization (for printNumbers(3))

```
FORWARD PHASE (Calls building up):
┌─────────────────────┐
│ printNumbers(0)     │  ← Base case (return immediately)
│ printNumbers(1)     │  
│ printNumbers(2)     │
│ printNumbers(3)     │  ← Our main call
└─────────────────────┘

BACKWARD PHASE (Unwind):
Call Stack unwinds from top to bottom:
1. printNumbers(0) → return
2. printNumbers(1) → return
3. printNumbers(2) → return
4. printNumbers(3) → return

Output printed during unwind: 3, 2, 1
```

### Stack Depth
For `printNumbers(n)`, stack depth = **n + 1**
```
printNumbers(5) → Stack depth = 6 frames
printNumbers(100) → Stack depth = 101 frames
printNumbers(1000000) → Stack depth = 1000001 frames ❌ OVERFLOW!
```

---

## Stack Overflow - What & Why?

### What is Stack Overflow?
**StackOverflowError**: Happens when the call stack exceeds memory limit.

```
Error: java.lang.StackOverflowError
    at YourClass.recursiveFunction(YourClass.java:5)
    at YourClass.recursiveFunction(YourClass.java:8)
    at YourClass.recursiveFunction(YourClass.java:8)
    ... (thousands of repeated lines)
```

### Common Causes

#### **Mistake 1: Missing Base Case**
```java
void wrong(int n) {
    System.out.println(n);
    wrong(n - 1);  // No base case! → INFINITE RECURSION
}
```
**Result**: Stack grows infinitely → StackOverflowError ❌

#### **Mistake 2: Base Case Never Reached**
```java
void wrong(int n) {
    if (n == 0) return;
    System.out.println(n);
    wrong(n);  // n never changes! → INFINITE
}
```
**Result**: Calls self with same parameter → StackOverflowError ❌

#### **Mistake 3: Too Deep Recursion**
```java
void factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

factorial(100000);  // Too many calls for stack memory
```
**Result**: Stack memory exhausted → StackOverflowError ❌

### Typical Stack Limits
| Language | Stack Size | Max Safe Depth |
|----------|-----------|----------------|
| Java | ~1-8 MB | ~10,000 |
| Python | ~8 MB | ~1,000 |
| C++ | Varies | ~100,000+ |

---

## Base Case - The Guardian

### Why Base Case is Critical?

```java
int factorial(int n) {
    if (n <= 1) {           // ← BASE CASE (MUST HAVE)
        return 1;
    }
    return n * factorial(n - 1);
}
```

**Without base case:**
```java
int wrong(int n) {
    return n * wrong(n - 1);  // ❌ No stop condition
}
// Result: StackOverflowError!
```

### Multiple Base Cases

Some problems need multiple base cases:

```java
int fibonacci(int n) {
    if (n == 0) return 0;      // Base case 1
    if (n == 1) return 1;      // Base case 2
    return fibonacci(n-1) + fibonacci(n-2);
}
```

### Base Case Checklist

✅ **Good Base Cases:**
- Clearly defined condition
- Returns without recursing
- Moves closer to base case each time
- Handles edge cases (0, 1, empty)

❌ **Bad Base Cases:**
- Missing
- Can never be reached
- Doesn't stop recursion

---

## Recursion Execution Flow

### Step-by-Step Example: sum(4)

```
Call: sum(4)

FORWARD (Going Down):
sum(4)
  ↓ calls sum(3)
    ↓ calls sum(2)
      ↓ calls sum(1)
        ↓ calls sum(0)
          ↓ BASE CASE → return 0

BACKWARD (Coming Back):
sum(1): return 1 + 0 = 1
sum(2): return 2 + 1 = 3
sum(3): return 3 + 3 = 6
sum(4): return 4 + 6 = 10 ← Final result

Stack grows to depth 5, then shrinks back to 1
```

### Visual Call Stack

```
TIME:  0      1      2      3      4      5      6      7      8

       sum(4)
       ├sum(3)
       │ ├sum(2)
       │ │ ├sum(1)
       │ │ │ ├sum(0) ← Peak (depth=5)
       │ │ │ ├← return 0
       │ │ ├← return 1
       │ ├← return 3
       │ ├← return 6
       ├← return 10 ← Final result

MEMORY: Growing up, then shrinking down
```

---

## Key Patterns

### Pattern 1: Print Before Recursion (Decreasing)
```java
void printBefore(int n) {
    if (n == 0) return;
    System.out.println(n);     // Print FIRST
    printBefore(n - 1);
}
// Output for n=3: 3, 2, 1 (Decreasing)
```

### Pattern 2: Print After Recursion (Increasing)
```java
void printAfter(int n) {
    if (n == 0) return;
    printAfter(n - 1);
    System.out.println(n);     // Print AFTER
}
// Output for n=3: 1, 2, 3 (Increasing)
```

### Pattern 3: Return Values
```java
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);     // Return combined result
}
```

### Pattern 4: Multiple Pointers
```java
void reverse(int[] arr, int left, int right) {
    if (left >= right) return;
    swap(arr[left], arr[right]);
    reverse(arr, left + 1, right - 1);  // Two pointers moving
}
```

---

## Recursion vs Iteration

| Aspect | Recursion | Iteration |
|--------|-----------|-----------|
| **Code** | Elegant, mathematical | Explicit loops |
| **Time** | O(n) for n calls | O(n) for n iterations |
| **Space** | O(n) call stack | O(1) usually |
| **Risk** | Stack overflow | None |
| **Speed** | Slower (function calls) | Faster |
| **Use** | Trees, backtracking | General problems |

### Same Problem: Two Ways

**Recursion:**
```java
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);  // Elegant
}
```

**Iteration:**
```java
int sumIterative(int n) {
    int total = 0;
    for (int i = 1; i <= n; i++) {
        total += i;
    }
    return total;  // Efficient
}
```

---

## Common Mistakes & Fixes

### Mistake 1: No Base Case
```java
// WRONG
void print(int n) {
    System.out.println(n);
    print(n - 1);  // ∞ infinite loop!
}

// RIGHT
void print(int n) {
    if (n == 0) return;        // ✓ Base case
    System.out.println(n);
    print(n - 1);
}
```

### Mistake 2: Not Moving Toward Base Case
```java
// WRONG
void print(int n) {
    if (n == 0) return;
    System.out.println(n);
    print(n);  // ∞ n never changes!
}

// RIGHT
void print(int n) {
    if (n == 0) return;
    System.out.println(n);
    print(n - 1);  // ✓ Moving to base case
}
```

### Mistake 3: Ignoring Return Value
```java
// WRONG
int sum(int n) {
    if (n == 0) return 0;
    sum(n - 1);      // Result lost! ✗
    return n;        // Only returns n
}

// RIGHT
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);  // ✓ Result combined
}
```

### Mistake 4: Too Deep Recursion
```java
// WRONG
fibonacci(10000);  // Stack overflow!

// RIGHT
// Use iteration or memoization
int[] memo = new int[n];
fibonacci(n, memo);  // Caching prevents overflow
```

---

## Performance Considerations

### Time Complexity
```
sum(n) → O(n) - makes n calls
factorial(n) → O(n) - makes n calls
fibonacci(n) → O(2^n) - exponential! ⚠️
```

### Space Complexity
```
sum(n) → O(n) - call stack depth n
factorial(n) → O(n) - call stack depth n
fibonacci(n) → O(n) - call stack depth n
```

### Optimization: Memoization
```java
int[] memo = new int[n + 1];

int fib(int n) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    
    memo[n] = fib(n - 1) + fib(n - 2);
    return memo[n];  // Cache result
}
// Reduces O(2^n) to O(n)! 🚀
```

---

## When to Use Recursion?

✅ **Good Use Cases:**
- Tree traversal (DFS)
- Graph algorithms (DFS)
- Backtracking (Sudoku, N-Queens)
- Mathematical sequences (Factorial, Fibonacci)
- Divide-and-conquer (Merge Sort, Quick Sort)
- Permutations & Combinations

❌ **Avoid Recursion:**
- Simple loops (use for/while)
- Very deep recursions (use iteration)
- Performance-critical code
- Limited stack memory

---

## Debugging Recursion

### Tips for Understanding
1. **Draw the call stack** - Visual helps!
2. **Trace with small values** - Use n=1, 2, 3
3. **Print at each level** - See what happens
4. **Check base case first** - Is it correct?
5. **Verify progress** - Does each call get closer?

### Example Debug Code
```java
int sum(int n, int depth) {
    String indent = "  ".repeat(depth);
    System.out.println(indent + "→ sum(" + n + ")");
    
    if (n == 0) {
        System.out.println(indent + "← return 0 (base case)");
        return 0;
    }
    
    int result = n + sum(n - 1, depth + 1);
    System.out.println(indent + "← return " + result);
    return result;
}

// Output shows entire execution tree!
```

---

## Quick Reference

| Concept | Key Point |
|---------|-----------|
| **Recursion** | Function calls itself |
| **Base Case** | When recursion stops |
| **Call Stack** | Memory stores function calls |
| **Stack Overflow** | Too many calls → memory full |
| **Depth** | Number of nested calls |
| **Time** | Usually O(n) or worse |
| **Space** | Usually O(n) for call stack |

---

## Next: See 6 Solved Problems! 👇
1. Print Name N Times
2. Print 1 to N
3. Sum of N Numbers
4. Factorial
5. Reverse Array
6. Palindrome Check

**Ready to solve problems?** → Check next files! 🚀
