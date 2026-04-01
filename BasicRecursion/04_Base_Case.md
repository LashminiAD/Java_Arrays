# Base Case - The Guardian of Recursion

## What is a Base Case?

### Definition
The **base case** is the condition that stops recursion and prevents infinite loops.

### Structure
```java
public static void recursive(int n) {
    // BASE CASE (Always first!)
    if (n == 0) {
        return;  // Stop recursion
    }
    
    // WORK (Do something)
    System.out.println(n);
    
    // RECURSIVE CASE (Call self)
    recursive(n - 1);
}
```

---

## Why Base Case is Critical

### Without Base Case ❌
```java
public static void wrong(int n) {
    System.out.println(n);
    wrong(n - 1);  // NO BASE CASE!
}

wrong(5);
// Output: 5, 4, 3, 2, 1, 0, -1, -2, -3, ... ∞
// Result: StackOverflowError ❌
```

### With Base Case ✓
```java
public static void correct(int n) {
    if (n == 0) return;        // ✓ BASE CASE
    System.out.println(n);
    correct(n - 1);
}

correct(5);
// Output: 5, 4, 3, 2, 1
// Result: Success ✓
```

---

## Types of Base Cases

### Type 1: Equality Check
```java
public static void count(int n) {
    if (n == 0) return;        // Stop when n equals 0
    System.out.println(n);
    count(n - 1);
}
```

### Type 2: Range Check
```java
public static void countTo(int n, int limit) {
    if (n > limit) return;     // Stop when exceeds limit
    System.out.println(n);
    countTo(n + 1, limit);
}
```

### Type 3: Collection Check
```java
public static void printArray(int[] arr, int index) {
    if (index >= arr.length) return;  // Stop at end of array
    System.out.println(arr[index]);
    printArray(arr, index + 1);
}
```

### Type 4: Existence Check
```java
public static void searchTree(TreeNode node) {
    if (node == null) return;  // Stop when node doesn't exist
    System.out.println(node.value);
    searchTree(node.left);
    searchTree(node.right);
}
```

### Type 5: Multiple Conditions
```java
public static void fibonacci(int n) {
    if (n == 0) return 0;      // Base case 1
    if (n == 1) return 1;      // Base case 2
    return fibonacci(n-1) + fibonacci(n-2);
}
```

---

## Multiple Base Cases

### When Multiple Base Cases Needed:

```java
// Fibonacci - Two base cases!
public static long fib(int n) {
    if (n == 0) return 0;      // Base case 1
    if (n == 1) return 1;      // Base case 2
    return fib(n - 1) + fib(n - 2);
}

// fib(0) = 0
// fib(1) = 1
// fib(2) = fib(1) + fib(0) = 1 + 0 = 1
// fib(3) = fib(2) + fib(1) = 1 + 1 = 2
```

### Why Both Needed?
```
Without fib(n==1) base case:
fib(2) = fib(1) + fib(0)
       = fib(0) + fib(-1) + fib(0)
       = 0 + fib(-1) + 0
       = fib(-1)
       = ... infinite! ❌

With both base cases:
fib(2) = fib(1) + fib(0) = 1 + 0 = 1 ✓
```

---

## Base Case Design Patterns

### Pattern 1: Decrement to Zero
```java
public static void pattern1(int n) {
    if (n == 0) return;        // Base: when n reaches 0
    System.out.println(n);
    pattern1(n - 1);           // Decrement each time
}

pattern1(5);
// Output: 5 4 3 2 1
```

### Pattern 2: Increment to Limit
```java
public static void pattern2(int n, int limit) {
    if (n > limit) return;     // Base: when n exceeds limit
    System.out.println(n);
    pattern2(n + 1, limit);    // Increment each time
}

pattern2(1, 5);
// Output: 1 2 3 4 5
```

### Pattern 3: Array Traversal
```java
public static void pattern3(int[] arr, int i) {
    if (i >= arr.length) return;  // Base: at end of array
    System.out.println(arr[i]);
    pattern3(arr, i + 1);         // Move to next index
}

pattern3(new int[]{10, 20, 30}, 0);
// Output: 10 20 30
```

### Pattern 4: Tree Traversal
```java
public static void pattern4(TreeNode node) {
    if (node == null) return;  // Base: null node
    System.out.println(node.value);
    pattern4(node.left);
    pattern4(node.right);
}

// Automatically handles tree end
```

### Pattern 5: Divide and Conquer
```java
public static void pattern5(int[] arr, int start, int end) {
    if (start > end) return;   // Base: when pointers cross
    int mid = (start + end) / 2;
    process(arr[mid]);
    pattern5(arr, start, mid - 1);
    pattern5(arr, mid + 1, end);
}
```

---

## Common Base Case Mistakes

### ❌ Mistake 1: No Base Case
```java
public static void wrong(int n) {
    System.out.println(n);
    wrong(n - 1);  // Infinite!
}

// Fix:
public static void correct(int n) {
    if (n == 0) return;  // Add base case
    System.out.println(n);
    correct(n - 1);
}
```

### ❌ Mistake 2: Wrong Base Case Condition
```java
public static void wrong(int n) {
    if (n == 5) return;  // Stops at 5, not end!
    System.out.println(n);
    wrong(n + 1);
}

// Fix:
public static void correct(int n, int limit) {
    if (n > limit) return;  // Clear condition
    System.out.println(n);
    correct(n + 1, limit);
}
```

### ❌ Mistake 3: Base Case After Work
```java
public static void wrong(int n) {
    System.out.println(n);     // Work first
    if (n == 0) return;        // Base case last (too late!)
    wrong(n - 1);
}

// When n = 0:
// - Prints 0 ✓
// - Checks if 0 == 0 ✓ returns
// But what if the WORK fails? We've already done damage!

// Fix:
public static void correct(int n) {
    if (n == 0) return;        // Base case FIRST
    System.out.println(n);     // Work second
    correct(n - 1);
}
```

### ❌ Mistake 4: Unreachable Base Case
```java
public static void wrong(int n) {
    if (n == 0) return;
    System.out.println(n);
    wrong(n + 1);  // n increases, never reaches 0!
}

// Fix:
public static void correct(int n) {
    if (n > 10) return;     // Correct stopping condition
    System.out.println(n);
    correct(n + 1);
}
```

### ❌ Mistake 5: Multiple Paths Don't All End
```java
public static void wrong(int n) {
    if (n == 0) return;
    
    if (n > 5) {
        System.out.println("Large: " + n);
        wrong(n - 2);
    } else {
        System.out.println("Small: " + n);
        wrong(n - 1);
    }
}

// If n = 6:
// Large path: 6 → 4 → 2 → 0 ✓ (OK)
// But very convoluted

// Fix:
public static void correct(int n) {
    if (n == 0) return;
    
    if (n > 5) {
        System.out.println("Large: " + n);
        correct(n - 2);
    } else {
        System.out.println("Small: " + n);
        correct(n - 1);
    }
}
```

---

## Base Case Verification Checklist

### ✓ Does your base case:

1. [ ] **Exist?** - Is there a return statement that doesn't recurse?
2. [ ] **Stop recursion?** - Does it prevent further calls?
3. [ ] **Get reached?** - Can the condition actually be true?
4. [ ] **Handle edge cases?** - What about n=0, null, empty?
5. [ ] **Come early?** - Is it checked BEFORE risky operations?
6. [ ] **Return correctly?** - Does it return the right type/value?
7. [ ] **Combine with recursion?** - Do ALL paths eventually reach it?

---

## Testing Base Cases

### Test Code
```java
public class BaseeCaseTest {
    public static int countDown(int n) {
        if (n == 0) return 0;  // Base case
        return 1 + countDown(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(countDown(0));      // Should be 0
        System.out.println(countDown(1));      // Should be 1
        System.out.println(countDown(5));      // Should be 5
        System.out.println(countDown(100));    // Should be 100
    }
}
```

### Expected Output
```
0
1
5
100
```

---

## Base Case in Real Problems

### Problem 1: Factorial
```java
public static int factorial(int n) {
    if (n <= 1) return 1;      // Base case: 0! = 1, 1! = 1
    return n * factorial(n - 1);
}

factorial(0);  // ✓ 1 (base case)
factorial(1);  // ✓ 1 (base case)
factorial(5);  // ✓ 120
```

### Problem 2: Sum
```java
public static int sum(int n) {
    if (n == 0) return 0;      // Base case: sum(0) = 0
    return n + sum(n - 1);
}

sum(0);  // ✓ 0 (base case)
sum(5);  // ✓ 15
```

### Problem 3: Fibonacci
```java
public static long fib(int n) {
    if (n == 0) return 0;      // Base case 1
    if (n == 1) return 1;      // Base case 2
    return fib(n - 1) + fib(n - 2);
}

fib(0);  // ✓ 0 (base case 1)
fib(1);  // ✓ 1 (base case 2)
fib(5);  // ✓ 5
```

---

**Next:** Compare Recursion vs Iteration → `05_Recursion_vs_Iteration.md`
