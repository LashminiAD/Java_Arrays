# What is Recursion?

## Simple Definition
**Recursion** = A function calling itself to solve a problem by breaking it into smaller, similar sub-problems.

## Visual Example

### Example 1: Counting Down
```
countDown(3)
├─ print "3"
├─ countDown(2)
│  ├─ print "2"
│  ├─ countDown(1)
│  │  ├─ print "1"
│  │  └─ countDown(0) → STOP
```

**Output:** 3, 2, 1 ✓

### Example 2: Factorial (5! = 120)
```
factorial(5)
├─ 5 * factorial(4)
│  ├─ 4 * factorial(3)
│  │  ├─ 3 * factorial(2)
│  │  │  ├─ 2 * factorial(1)
│  │  │  │  └─ 1 (BASE CASE)
```

**Result:** 5 × 4 × 3 × 2 × 1 = 120 ✓

---

## Real-World Analogies

### 1. Russian Nesting Dolls 🪆
```
Open Doll 5
└─ Contains Doll 4
   └─ Contains Doll 3
      └─ Contains Doll 2
         └─ Contains Doll 1 (SMALLEST - BASE CASE)
```

### 2. Dictionary Definition
```
Q: What is Recursion?
A: See "Recursion" ← Recursive definition!

Q: What is Recursion?
A: A technique where something is defined in terms of itself
   (but simpler version)
```

### 3. Searching Folders
```
Search for file in folder:
├─ Check current folder
├─ If found → return ✓
├─ If not → Search subfolders (same function)
└─ Keep going until found or no more folders
```

---

## Key Requirements

### For ANY recursion to work, you NEED:

1. **Base Case** (Stop Condition)
   ```java
   if (condition) return;  // MUST EXIT
   ```

2. **Recursive Case** (Continue Condition)
   ```java
   function(simpler_problem);  // Calls itself
   ```

3. **Progress Toward Base Case**
   ```java
   function(n - 1);  // Get closer each time
   ```

---

## Why Use Recursion?

✅ **Advantages:**
- **Natural fit** for problems that are naturally recursive
- **Clean code** - simpler than equivalent loops
- **Mathematical elegance** - mirrors mathematical thinking
- **Trees/Graphs** - perfect for hierarchical structures

❌ **Disadvantages:**
- **Slower** - function call overhead
- **Stack overflow** - limited recursion depth
- **Harder to debug** - complex call stacks
- **More memory** - each call needs stack space

---

## Types of Recursion

### Type 1: Direct Recursion
Function calls itself directly:
```java
void func(int n) {
    if (n == 0) return;
    func(n - 1);  // Direct call to itself
}
```

### Type 2: Indirect Recursion
Function calls another function that calls back:
```java
void funcA(int n) {
    if (n == 0) return;
    funcB(n - 1);  // Calls funcB
}

void funcB(int n) {
    funcA(n);      // funcB calls back to funcA
}
```

### Type 3: Tail Recursion
Recursive call is the last operation:
```java
int factorial(int n, int acc) {
    if (n <= 1) return acc;
    return factorial(n - 1, n * acc);  // Last call
}
```
✓ Can be optimized by compilers!

---

## Comparison with Loops

### Same Problem: Print 1 to 5

**Recursion:**
```java
void printRecursive(int n) {
    if (n == 0) return;
    printRecursive(n - 1);
    System.out.println(n);
}
// Elegant but slower
```

**Loop:**
```java
void printLoop(int n) {
    for (int i = 1; i <= n; i++) {
        System.out.println(i);
    }
}
// Efficient and straightforward
```

**Output:** Both print 1, 2, 3, 4, 5

---

## When Recursion Shines

### Problem 1: Tree Traversal
```
        A
       / \
      B   C
     / \
    D   E

To visit all nodes, recursion is PERFECT!
```

### Problem 2: Factorial
```
5! = 5 × 4!
4! = 4 × 3!
3! = 3 × 2!
2! = 2 × 1!
1! = 1

Naturally recursive structure!
```

### Problem 3: Fibonacci
```
fib(5) = fib(4) + fib(3)
fib(4) = fib(3) + fib(2)
fib(3) = fib(2) + fib(1)

Mathematical recursion!
```

---

## Recursion in Nature

```
File System:
Folder
├─ Subfolder (same structure)
│  ├─ Subfolder (same structure)
│  └─ Files
└─ Files

Binary Tree:
    Node
    /  \
   Node  Node
   / \
 Node Node

Fractals:
Self-similar patterns at different scales

Algorithms:
Merge Sort - divide array, sort, merge
Quick Sort - partition, sort, combine
```

---

## Quick Quiz

**Q1:** What makes a function recursive?
**A:** When it calls itself (directly or indirectly)

**Q2:** What's essential to prevent infinite recursion?
**A:** A base case that returns without recursing

**Q3:** What happens if base case is missing?
**A:** StackOverflowError - the stack grows forever until memory runs out

**Q4:** Is recursion always better than loops?
**A:** No! Use recursion for naturally recursive problems. Use loops for simple iterations.

**Q5:** When would you prefer iteration over recursion?
**A:** When you have simple loops, performance matters, or recursion depth might be huge.

---

**Next:** Learn how recursion actually executes → `02_How_Recursion_Works.md`
