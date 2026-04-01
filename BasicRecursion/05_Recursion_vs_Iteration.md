# Recursion vs Iteration - Complete Comparison

## Side-by-Side Comparison

### Same Problem: Sum of 1 to N

**Recursion:**
```java
public static int sumRecursive(int n) {
    if (n == 0) return 0;
    return n + sumRecursive(n - 1);
}

sumRecursive(5);  // = 15
```

**Iteration:**
```java
public static int sumIterative(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i;
    }
    return sum;
}

sumIterative(5);  // = 15
```

**Mathematical:**
```java
public static int sumFormula(int n) {
    return n * (n + 1) / 2;
}

sumFormula(5);  // = 15
```

---

## Detailed Comparison Table

| Aspect | Recursion | Iteration | Formula |
|--------|-----------|-----------|---------|
| **Code Style** | Elegant, mathematical | Straightforward | Optimal |
| **Readability** | High (for experts) | High (for all) | High |
| **Ease of Understanding** | Medium | Easy | Hard |
| **Time Complexity** | O(n) | O(n) | O(1) |
| **Space Complexity** | O(n) | O(1) | O(1) |
| **Stack Memory** | Uses it | Doesn't use | Doesn't use |
| **Performance** | Slower | Faster | Fastest |
| **Overflow Risk** | High (stack) | None | None |
| **Debug Difficulty** | Hard | Easy | Very Easy |
| **Best For** | Trees, backtracking | Loops, iterations | Direct calculation |

---

## Performance Analysis

### Time Complexity: Same
```java
// Recursion: O(n)
public static int sumRec(int n) {
    if (n == 0) return 0;
    return n + sumRec(n - 1);  // n calls
}

// Iteration: O(n)
public static int sumIter(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {  // n iterations
        sum += i;
    }
    return sum;
}

// Both make n operations
```

### Space Complexity: DIFFERENT
```java
// Recursion: O(n) space
// Stack grows to depth n
// Stack usage: n frames × ~100 bytes = n×100 bytes

// Iteration: O(1) space
// Only uses constant extra space
// Stack usage: Just one frame

// For n = 10,000:
// Recursion: ~1 MB of stack
// Iteration: ~0.01 MB
```

### Actual Speed Test

```java
long start = System.nanoTime();
sumRecursive(10000);
long recursiveTime = System.nanoTime() - start;

start = System.nanoTime();
sumIterative(10000);
long iterativeTime = System.nanoTime() - start;

System.out.println("Recursive: " + recursiveTime + " ns");
System.out.println("Iterative: " + iterativeTime + " ns");

// Typical Output:
// Recursive: 450,000 ns (slower)
// Iterative: 150,000 ns (faster)
// Recursive is ~3x slower!
```

---

## Memory Usage

### Recursion: Call Stack

```java
sumRecursive(5)
├─ Frame 1: n=5
├─ Frame 2: n=4
├─ Frame 3: n=3
├─ Frame 4: n=2
├─ Frame 5: n=1
└─ Frame 6: n=0

Memory: 6 frames × 100 bytes ≈ 600 bytes
Stack depth: 6

sumRecursive(1000):
Memory: 1000 × 100 ≈ 100 KB
Stack depth: 1000

sumRecursive(100000):
Memory: 100000 × 100 ≈ 10 MB
Result: StackOverflowError! (exceeds 1-8 MB limit)
```

### Iteration: Fixed Memory

```java
sumIterative(5)
├─ Variables: sum, i
├─ Memory: constant ~20 bytes
└─ Stack depth: 1

sumIterative(1000):
Memory: ~20 bytes (same!)
Stack depth: 1

sumIterative(1000000):
Memory: ~20 bytes (same!)
Stack depth: 1
Result: Success! ✓
```

---

## Code Elegance

### Recursion: Mathematical Beauty

```java
// Fibonacci: reads like math
public static long fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);  // f(n) = f(n-1) + f(n-2)
}

// Tree traversal: naturally recursive
public static void traverse(TreeNode node) {
    if (node == null) return;
    visit(node);
    traverse(node.left);
    traverse(node.right);
}

// Backtracking: perfect fit
public static void solveNQueens(int row) {
    if (row == n) {
        printSolution();
        return;
    }
    for (int col = 0; col < n; col++) {
        if (isSafe(row, col)) {
            place(row, col);
            solveNQueens(row + 1);
            remove(row, col);
        }
    }
}
```

### Iteration: Clear and Direct

```java
// Sum: straightforward loop
public static int sum(int n) {
    int total = 0;
    for (int i = 1; i <= n; i++) {
        total += i;
    }
    return total;
}

// Array processing: simple loops
public static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

// State machine: explicit
public static void processItems(List<Item> items) {
    for (Item item : items) {
        if (item.isValid()) {
            process(item);
        }
    }
}
```

---

## Real-World Examples

### Example 1: File System Search

#### ❌ Recursion (Risk of StackOverflow)
```java
public static void searchFilesRecursive(File dir) {
    for (File file : dir.listFiles()) {
        if (file.isDirectory()) {
            searchFilesRecursive(file);  // Deep nesting → crash!
        } else {
            process(file);
        }
    }
}

// Problem: Very deep directory → StackOverflowError
```

#### ✅ Iteration (Always Safe)
```java
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

// Safe: no stack overflow, no matter depth
```

---

### Example 2: Tree Traversal

#### ✅ Recursion (Natural Fit)
```java
public static void inOrder(TreeNode node) {
    if (node == null) return;
    
    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
}

// Perfect: matches tree structure!
```

#### ✓ Iteration (Works but Complex)
```java
public static void inOrderIterative(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        System.out.println(current.value);
        current = current.right;
    }
}

// Works: but more code, needs manual stack management
```

---

### Example 3: Factorial

#### ✓ Recursion (Clean)
```java
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

// 5! = 120
```

#### ✓ Iteration (Also Clean)
```java
public static int factorialIterative(int n) {
    int result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}

// 5! = 120
```

#### ⭐ Formula (Best)
```java
// Use Apache Commons Math or BigInteger
// factorial(5) = 120
```

---

## Deciding: Recursion or Iteration?

### Use Recursion When:

✅ **Problem is naturally recursive**
- Tree traversal
- Graph DFS
- Backtracking (N-Queens, Sudoku)
- Divide and conquer (Merge Sort, Quick Sort)
- Mathematical sequences (Fibonacci)

✅ **Recursion depth is SMALL**
- Depth < 1000
- Unlikely to overflow

✅ **Readability is more important than performance**
- Once-a-week operations
- Interview problems
- Educational code

### Use Iteration When:

✅ **Performance is critical**
- Real-time systems
- High-frequency operations
- Millions of iterations

✅ **Stack safety needed**
- Unknown recursion depth
- Could be very large
- Production systems

✅ **Simplicity matters**
- Straightforward loops
- Simple counter patterns
- Explicit state management

✅ **Memory is limited**
- Embedded systems
- Mobile apps
- Limited stack space

---

## Conversion Guide

### Recursion → Iteration

**Pattern: Decrement to 0**

```java
// Recursive
public static void printRec(int n) {
    if (n == 0) return;
    System.out.println(n);
    printRec(n - 1);
}

// Iterative (use Loop)
public static void printIter(int n) {
    for (int i = n; i > 0; i--) {
        System.out.println(i);
    }
}

// Both output: n, n-1, ..., 1
```

**Pattern: Accumulate Value**

```java
// Recursive
public static int sumRec(int n) {
    if (n == 0) return 0;
    return n + sumRec(n - 1);
}

// Iterative (use Loop + Accumulator)
public static int sumIter(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += i;
    }
    return sum;
}

// Both return: sum of 1..n
```

**Pattern: Tree/Graph**

```java
// Recursive
public static void dfs(Node node) {
    if (node == null) return;
    visit(node);
    for (Node child : node.children) {
        dfs(child);
    }
}

// Iterative (use Stack)
public static void dfsIterative(Node root) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.isEmpty()) {
        Node node = stack.pop();
        visit(node);
        for (Node child : node.children) {
            stack.push(child);
        }
    }
}

// Both visit nodes in DFS order
```

---

## Best Practices

### ✓ Recursion Best Practices:
1. Always have a base case
2. Ensure progress toward base case
3. Keep recursion depth reasonable (< 1000)
4. Consider iteration for large inputs
5. Use memoization for repeated subproblems

### ✓ Iteration Best Practices:
1. Use clear loop conditions
2. Avoid infinite loops (check termination)
3. Comment complex loop logic
4. Consider while vs for vs foreach
5. Use appropriate data structures (Stack, Queue)

---

## Summary Table

| Scenario | Choose |
|----------|--------|
| Tree/Graph traversal | Recursion |
| Simple counting loop | Iteration |
| Backtracking/Puzzle | Recursion |
| Large dataset processing | Iteration |
| Performance critical | Iteration |
| Code readability first | Recursion |
| Unknown max depth | Iteration |
| Mathematical function | Recursion |
| Unknown input size | Iteration |
| Educational/Interview | Either (but explain both!) |

---

**Next:** Learn Common Mistakes → `06_Common_Mistakes.md`
