# Common Recursion Mistakes - Learn from Them

## Mistake 1: Forgetting the Base Case

### ❌ Wrong Code
```java
public static void printNumbers(int n) {
    System.out.println(n);
    printNumbers(n - 1);  // NO BASE CASE!
}

printNumbers(5);
```

**What Happens:**
```
Output: 5, 4, 3, 2, 1, 0, -1, -2, ... ∞
Error: java.lang.StackOverflowError
```

### ✅ Correct Code
```java
public static void printNumbers(int n) {
    if (n == 0) return;           // ✓ BASE CASE
    System.out.println(n);
    printNumbers(n - 1);
}

printNumbers(5);
```

**What Happens:**
```
Output: 5, 4, 3, 2, 1
Result: Success ✓
```

### Lesson:
**ALWAYS start with the base case. Check it first!**

---

## Mistake 2: Base Case That Never Gets Reached

### ❌ Wrong Code
```java
public static void countdown(int n) {
    if (n == 0) return;          // Will never reach 0
    System.out.println(n);
    countdown(n);                 // n NEVER CHANGES!
}

countdown(5);
```

**What Happens:**
```
Output: 5, 5, 5, 5, 5, ... ∞
Error: java.lang.StackOverflowError
```

### ✅ Correct Code
```java
public static void countdown(int n) {
    if (n == 0) return;          // ✓ Can reach 0
    System.out.println(n);
    countdown(n - 1);            // ✓ n decreases by 1
}

countdown(5);
```

**What Happens:**
```
Output: 5, 4, 3, 2, 1
Result: Success ✓
```

### Lesson:
**Each recursive call must move CLOSER to the base case!**

---

## Mistake 3: Not Returning the Recursive Result

### ❌ Wrong Code
```java
public static int sum(int n) {
    if (n == 0) return 0;
    sum(n - 1);                  // ✗ Result not used!
    return n;                    // ✗ Only returns n
}

sum(5);
// Expected: 1 + 2 + 3 + 4 + 5 = 15
// Actual: 5 (only returns last n)
```

**Trace:**
```
sum(5) → sum(4) → sum(3) → sum(2) → sum(1) → sum(0)
Return values:
sum(0) = 0
sum(1) = 1 (not combined with sum(0))
sum(2) = 2 (not combined with sum(1))
sum(3) = 3
sum(4) = 4
sum(5) = 5

Result: 5 ✗ (should be 15)
```

### ✅ Correct Code
```java
public static int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);       // ✓ Combine result
}

sum(5);
// Result: 15 ✓
```

**Trace:**
```
sum(5) returns 5 + sum(4)
  sum(4) returns 4 + sum(3)
    sum(3) returns 3 + sum(2)
      sum(2) returns 2 + sum(1)
        sum(1) returns 1 + sum(0)
          sum(0) returns 0

Unwinding:
sum(1) = 1 + 0 = 1
sum(2) = 2 + 1 = 3
sum(3) = 3 + 3 = 6
sum(4) = 4 + 6 = 10
sum(5) = 5 + 10 = 15 ✓
```

### Lesson:
**RETURN the combined result, don't lose it!**

---

## Mistake 4: Off-by-One Errors

### ❌ Wrong Code
```java
public static void printNumbers(int n) {
    if (n == 1) return;          // Stops at 1, not 0
    System.out.println(n);
    printNumbers(n - 1);
}

printNumbers(5);
```

**What Happens:**
```
Output: 5, 4, 3, 2
Missing: 1 ✗
```

### ✅ Correct Code
```java
public static void printNumbers(int n) {
    if (n == 0) return;          // ✓ Stops at 0
    System.out.println(n);
    printNumbers(n - 1);
}

printNumbers(5);
```

**What Happens:**
```
Output: 5, 4, 3, 2, 1 ✓
```

### Another Example:
```java
// ✗ WRONG
public static void printArray(int[] arr, int i) {
    if (i >= arr.length) return;
    System.out.println(arr[i]);
    printArray(arr, i++);        // Off by one! i++ happens after
}

// ✓ RIGHT
public static void printArray(int[] arr, int i) {
    if (i >= arr.length) return;
    System.out.println(arr[i]);
    printArray(arr, i + 1);      // Correct increment
}
```

### Lesson:
**Double-check boundary conditions! (n==0 vs n==1, i>=length vs i>length)**

---

## Mistake 5: Too Much Work in One Call

### ❌ Wrong Code
```java
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);  // Recalculates same values!
}

fibonacci(40);  // Takes 30+ seconds!
fibonacci(50);  // StackOverflowError!
```

**Why So Slow?**
```
fibonacci(5) calls:
fibonacci(4) + fibonacci(3)
  fibonacci(3) + fibonacci(2) + fibonacci(3) + fibonacci(2)
    (fibonacci(3) calculated TWICE!)
    
fibonacci(3) is recalculated many times!

Calls for fib(5): ~15
Calls for fib(10): ~177
Calls for fib(20): ~21,891
Calls for fib(40): ~2 BILLION! 😱
```

### ✅ Correct Code - With Memoization
```java
public static class FibMemo {
    private Map<Integer, Long> memo = new HashMap<>();
    
    public long fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        
        long result = fib(n-1) + fib(n-2);
        memo.put(n, result);
        return result;
    }
}

FibMemo f = new FibMemo();
f.fib(40);   // Instant ✓
f.fib(100);  // Still fast ✓
```

### ✓ Better - Use Iteration
```java
public static long fibIterative(int n) {
    if (n <= 1) return n;
    long prev = 0, curr = 1;
    for (int i = 2; i <= n; i++) {
        long next = prev + curr;
        prev = curr;
        curr = next;
    }
    return curr;
}

fibIterative(100);  // Fast ✓
```

### Lesson:
**Identify exponential recursion patterns and use memoization or iteration!**

---

## Mistake 6: Infinite Mutual Recursion

### ❌ Wrong Code
```java
public static void funcA(int n) {
    System.out.println("A: " + n);
    funcB(n - 1);               // No base case check!
}

public static void funcB(int n) {
    System.out.println("B: " + n);
    funcA(n - 1);               // No base case check!
}

funcA(5);
```

**What Happens:**
```
A: 5 → B: 4 → A: 3 → B: 2 → A: 1 → B: 0 → A: -1 → B: -2 → ...
Error: java.lang.StackOverflowError
```

### ✅ Correct Code
```java
public static void funcA(int n) {
    if (n == 0) return;         // ✓ Base case
    System.out.println("A: " + n);
    funcB(n - 1);
}

public static void funcB(int n) {
    if (n == 0) return;         // ✓ Base case
    System.out.println("B: " + n);
    funcA(n - 1);
}

funcA(5);
```

**What Happens:**
```
A: 5 → B: 4 → A: 3 → B: 2 → A: 1 → stop
Result: Success ✓
```

### Lesson:
**BOTH functions in mutual recursion need base cases!**

---

## Mistake 7: Forgetting to Update State

### ❌ Wrong Code
```java
public static int count = 0;

public static void increment(int n) {
    if (n == 0) return;
    count++;
    increment(n - 1);
}

// Works fine, but...
increment(5);
System.out.println(count);  // 5

increment(3);
System.out.println(count);  // 8 (accumulated from before!)
```

**Problem:** Global state gets messed up!

### ✅ Correct Code
```java
public static int increment(int n) {
    if (n == 0) return 0;
    return 1 + increment(n - 1);
}

int count1 = increment(5);
System.out.println(count1);  // 5 ✓

int count2 = increment(3);
System.out.println(count2);  // 3 ✓ (independent)
```

### Lesson:
**Avoid global state in recursion. Use return values instead!**

---

## Mistake 8: Stack Overflow from Too-Deep Recursion

### ❌ Wrong Code
```java
public static void factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

factorial(50000);  // StackOverflowError!
```

### ✅ Correct Code
```java
// Method 1: Iterative
public static int factorialIter(int n) {
    int result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}

// Method 2: Tail Recursion (compiler optimized)
public static int factorialTail(int n, int acc) {
    if (n <= 1) return acc;
    return factorialTail(n - 1, n * acc);
}

// Method 3: Check depth
public static int factorialSafe(int n, int depth) {
    if (depth > 5000) {
        throw new RuntimeException("Too deep!");
    }
    if (n <= 1) return 1;
    return n * factorialSafe(n - 1, depth + 1);
}

factorialIter(50000);      // ✓ Works!
```

### Lesson:
**For very deep recursion, use iteration or check depth limits!**

---

## Mistake 9: Wrong Comparison Operators

### ❌ Wrong Code
```java
public static void count(int n, int limit) {
    if (n < limit) return;      // Stops too early!
    System.out.println(n);
    count(n + 1, limit);
}

count(1, 5);
// Output: (nothing) ✗
```

### ✅ Correct Code
```java
public static void count(int n, int limit) {
    if (n > limit) return;      // ✓ Correct
    System.out.println(n);
    count(n + 1, limit);
}

count(1, 5);
// Output: 1, 2, 3, 4, 5 ✓
```

### Another Example:
```java
// ✗ WRONG
public static void printArray(int[] arr, int i) {
    if (i < arr.length) {        // Wrong direction!
        printArray(arr, i + 1);
        System.out.println(arr[i]);
    }
}

// ✓ RIGHT
public static void printArray(int[] arr, int i) {
    if (i >= arr.length) return; // ✓ Correct
    System.out.println(arr[i]);
    printArray(arr, i + 1);
}
```

### Lesson:
**Choose the RIGHT comparison operator! (<, >, <=, >=, ==, !=)**

---

## Mistake 10: Not Understanding Variable Scope

### ❌ Wrong Code
```java
public static void modifyArray(int[] arr, int i, int value) {
    int temp = value;            // Local to this call only!
    if (i >= arr.length) return;
    
    arr[i] = temp;
    temp++;                       // Doesn't affect next call!
    
    modifyArray(arr, i + 1, temp);  // value increments, not temp
}
```

### ✅ Correct Code
```java
public static void modifyArray(int[] arr, int i, int value) {
    if (i >= arr.length) return;
    
    arr[i] = value;
    modifyArray(arr, i + 1, value + 1);  // Pass new value
}
```

### Lesson:
**Understand what's local vs global in each recursive call!**

---

## Quick Checklist: Before You Finalize

### ✓ My Recursion:

- [ ] Has a base case?
- [ ] Base case is reachable?
- [ ] Each call moves toward base case?
- [ ] Returns values correctly?
- [ ] No infinite loops or mutual recursion issues?
- [ ] Depth won't exceed ~10,000?
- [ ] All comparison operators correct?
- [ ] No global state issues?
- [ ] Tested with small values (n=0, 1, 2, 3)?
- [ ] Performance acceptable?

---

## Testing Your Recursion

### Test Template
```java
public static void testRecursion() {
    // Test 1: Base case
    assert function(0) == expected0;
    
    // Test 2: Small value
    assert function(1) == expected1;
    
    // Test 3: Medium value
    assert function(5) == expected5;
    
    // Test 4: Larger value
    assert function(100) == expected100;
    
    // Test 5: Edge cases
    assert function(-1) handles gracefully;
    
    System.out.println("All tests passed!");
}
```

---

**You're Ready!** → Now solve the 6 problems! 🚀
