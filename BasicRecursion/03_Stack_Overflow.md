# Stack Overflow - Complete Guide

## What is Stack Overflow?

### Definition
**StackOverflowError**: An exception thrown when the call stack exceeds its memory limit.

### Error Message
```
Exception in thread "main" java.lang.StackOverflowError
    at YourClass.recursiveFunction(YourClass.java:5)
    at YourClass.recursiveFunction(YourClass.java:8)
    at YourClass.recursiveFunction(YourClass.java:8)
    at YourClass.recursiveFunction(YourClass.java:8)
    at YourClass.recursiveFunction(YourClass.java:8)
    ... (thousands of repeated lines)
    at YourClass.main(YourClass.java:20)
```

---

## The Stack Memory Concept

### How Stack Memory Works

```
Stack grows UPWARD:

Top of Stack ↑
│
├─ [Function Call 1000]  ← Latest call
├─ [Function Call 999]
├─ [Function Call 998]
├─ ...
├─ [Function Call 2]
├─ [Function Call 1]
│
Bottom of Stack

When stack gets too tall → STACK OVERFLOW!
```

### Stack Size Limits

```
JAVA:
├─ Typically: 1 MB to 8 MB
├─ Safe depth: ~5,000-10,000 calls
├─ Each frame: ~50-100 bytes

PYTHON:
├─ Typically: 8 MB
├─ Safe depth: ~1,000-3,000 calls
├─ Default limit: 1,000 recursion depth

C++:
├─ Varies by system
├─ Can be several MB
├─ Configurable

JAVASCRIPT:
├─ Varies by browser/engine
├─ Chrome: ~15,000-20,000
├─ Node.js: ~10,000-15,000
```

---

## Common Causes of Stack Overflow

### ❌ Cause 1: Missing Base Case

```java
public static void wrong(int n) {
    System.out.println(n);
    wrong(n - 1);  // NO BASE CASE!
}

wrong(5);
// Output: 5 4 3 2 1 0 -1 -2 -3 ... (INFINITE)
// Result: StackOverflowError ❌
```

**Fix:**
```java
public static void correct(int n) {
    if (n == 0) return;           // ✓ BASE CASE
    System.out.println(n);
    correct(n - 1);
}

correct(5);
// Output: 5 4 3 2 1 (STOPS)
// Result: Success ✓
```

---

### ❌ Cause 2: Base Case Never Reached

```java
public static void wrong(int n) {
    if (n == 0) return;
    System.out.println(n);
    wrong(n);  // n NEVER CHANGES!
}

wrong(5);
// Keeps calling wrong(5) forever
// Result: StackOverflowError ❌
```

**Fix:**
```java
public static void correct(int n) {
    if (n == 0) return;
    System.out.println(n);
    correct(n - 1);  // ✓ n DECREASES
}

correct(5);
// Output: 5 4 3 2 1
// Result: Success ✓
```

---

### ❌ Cause 3: Wrong Base Case Condition

```java
public static void wrong(int n) {
    if (n == 10) return;  // Stops at 10, not 0
    System.out.println(n);
    wrong(n + 1);         // INCREASING n
}

wrong(5);
// Calls: wrong(5), wrong(6), wrong(7), ... wrong(9), wrong(10) STOP
// Output: 5 6 7 8 9
// Result: Success (but might overflow if different conditions)
```

**Better:**
```java
public static void correct(int n) {
    if (n > 10) return;   // Clear condition
    System.out.println(n);
    correct(n + 1);       // INCREASING by 1
}

correct(5);
// Stops when n > 10
// Output: 5 6 7 8 9 10
// Result: Success ✓
```

---

### ❌ Cause 4: Too Deep Recursion

```java
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

factorial(50000);  // Tries to make 50,000 calls
// Stack size: ~1 MB
// Each call: ~100 bytes
// Total needed: 50,000 × 100 = 5 MB (too much!)
// Result: StackOverflowError ❌
```

**Safe:**
```java
factorial(1000);   // ~1,000 calls = ~100 KB ✓
factorial(5000);   // ~5,000 calls = ~500 KB ✓
factorial(10000);  // ~10,000 calls = ~1 MB (risky)
factorial(50000);  // Exceeds stack ❌
```

---

### ❌ Cause 5: Mutual Recursion Loop

```java
public static void funcA(int n) {
    if (n == 0) return;
    System.out.println("A: " + n);
    funcB(n - 1);
}

public static void funcB(int n) {
    System.out.println("B: " + n);
    funcA(n);  // Calls back to funcA!
}

funcA(5);
// funcA(5) → funcB(4) → funcA(4) → funcB(3) → ...
// Infinite loop! (funcB never decreases n)
// Result: StackOverflowError ❌
```

**Fix:**
```java
public static void funcA(int n) {
    if (n == 0) return;      // ✓ BASE CASE
    System.out.println("A: " + n);
    funcB(n - 1);
}

public static void funcB(int n) {
    if (n == 0) return;      // ✓ BASE CASE in B too!
    System.out.println("B: " + n);
    funcA(n - 1);            // ✓ DECREASING
}

funcA(5);
// Works correctly now
// Output: A: 5 → B: 4 → A: 3 → B: 2 → A: 1 → stop
// Result: Success ✓
```

---

## Detecting Stack Overflow

### Signs:
1. ✗ Program crashes suddenly
2. ✗ Error message mentions StackOverflowError
3. ✗ Repeated line numbers in stack trace
4. ✗ Program slows down before crashing (stack filling up)

### Stack Trace Clue:
```
at YourClass.method(YourClass.java:8)
at YourClass.method(YourClass.java:8)
at YourClass.method(YourClass.java:8)
at YourClass.method(YourClass.java:8)
... (SAME LINE REPEATED = INFINITE RECURSION!)
```

---

## Prevention Strategies

### Strategy 1: Always Have a Base Case
```java
✓ GOOD
public static int sum(int n) {
    if (n == 0) return 0;           // BASE CASE
    return n + sum(n - 1);
}

✗ BAD
public static int sum(int n) {
    return n + sum(n - 1);          // No base case!
}
```

### Strategy 2: Ensure Progress Toward Base Case
```java
✓ GOOD
public static void print(int n) {
    if (n == 0) return;
    System.out.println(n);
    print(n - 1);                   // Gets closer to 0
}

✗ BAD
public static void print(int n) {
    if (n == 0) return;
    System.out.println(n);
    print(n);                       // Never reaches 0!
}
```

### Strategy 3: Check Maximum Recursion Depth
```java
public static void limitedRecursion(int n, int maxDepth) {
    if (n == 0) return;
    if (maxDepth <= 0) {
        System.out.println("Max depth reached!");
        return;
    }
    
    System.out.println(n);
    limitedRecursion(n - 1, maxDepth - 1);
}

limitedRecursion(100000, 5000);  // Limited to 5000 calls
```

### Strategy 4: Use Iteration Instead
```java
✓ SAFE (No stack overflow possible)
public static int sum(int n) {
    int total = 0;
    for (int i = 1; i <= n; i++) {
        total += i;
    }
    return total;
}

// Even for n = 1,000,000,000 - no problem!
```

### Strategy 5: Use Memoization
```java
public static class Fibonacci {
    private Map<Integer, Long> memo = new HashMap<>();
    
    public long fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        
        long result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }
}

// Reduces redundant calls
// fib(100) now works! (without memo: crashes)
```

### Strategy 6: Tail Recursion Optimization
```java
// Not tail recursive (needs to remember n for multiplication)
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);    // Does work AFTER return
}

// Tail recursive (last operation is recursion)
public static int factorialTail(int n, int acc) {
    if (n <= 1) return acc;
    return factorialTail(n - 1, n * acc);  // LAST operation
}

// Some languages/compilers optimize tail recursion
// (Not optimized in Java by default)
```

---

## Real-World Examples

### ❌ Example 1: Fibonacci Without Memoization

```java
public static long fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}

fib(10);    // ✓ Works (~177 calls)
fib(50);    // ✗ CRASH (StackOverflowError)
            // Would need ~1.25 × 10^16 calls!
```

**Why?**
```
fib(5) calls fib(4) + fib(3)
fib(4) calls fib(3) + fib(2)
fib(3) called TWICE! (redundant)

Exponential growth: O(2^n)
fib(50) = 2^50 = 1,125,899,906,842,624 calls!
```

**Solution:**
```java
public static long fibMemo(int n, Map<Integer, Long> memo) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    
    long result = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    memo.put(n, result);
    return result;
}

fibMemo(50, new HashMap<>());  // ✓ Works! (~50 calls)
```

---

### ❌ Example 2: Deep Directory Search

```java
public static void searchFiles(File dir) {
    for (File file : dir.listFiles()) {
        if (file.isDirectory()) {
            searchFiles(file);  // Recursive
        } else {
            process(file);
        }
    }
}

// Problem: Very deep folder structure → StackOverflow
// C:\A\B\C\D\....\Z\... (1000s of levels)
```

**Solution:**
```java
// Use iterative approach with Queue
public static void searchFilesIterative(File dir) {
    Queue<File> queue = new LinkedList<>();
    queue.add(dir);
    
    while (!queue.isEmpty()) {
        File current = queue.poll();
        for (File file : current.listFiles()) {
            if (file.isDirectory()) {
                queue.add(file);
            } else {
                process(file);
            }
        }
    }
}
```

---

## Testing for Stack Overflow

### Test Code
```java
public class StackOverflowTest {
    public static void causeOverflow(int depth) {
        System.out.println(depth);
        if (depth > 0) {
            causeOverflow(depth + 1);
        }
    }
    
    public static void main(String[] args) {
        try {
            causeOverflow(0);
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow at depth!");
            e.printStackTrace();
        }
    }
}
```

### Output
```
1
2
3
...
10847  ← Max depth reached
Exception in thread "main" java.lang.StackOverflowError
```

---

## Quick Checklist

### ✓ Prevent Stack Overflow:

- [ ] Do I have a BASE CASE?
- [ ] Does each call move CLOSER to base case?
- [ ] Is my recursion depth REASONABLE (< 10,000)?
- [ ] Could I use ITERATION instead?
- [ ] Do I have MUTUAL RECURSION that might loop?
- [ ] Are there EXPONENTIAL calls like Fibonacci?
- [ ] Can I use MEMOIZATION to reduce calls?

---

**Next:** Master the Base Case → `04_Base_Case.md`
