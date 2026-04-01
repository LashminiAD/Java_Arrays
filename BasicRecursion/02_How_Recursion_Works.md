# How Recursion Works - Detailed Execution

## The Call Stack Explained

### What is a Stack?
A **stack** is a data structure that works like a **stack of plates**:
- Add plates on **top** (PUSH)
- Remove plates from **top** (POP)
- Last added = First removed (LIFO - Last In First Out)

```
PUSH 1:     │ 1 │
            └───┘

PUSH 2:     │ 2 │
            │ 1 │
            └───┘

PUSH 3:     │ 3 │      POP:     │ 2 │
            │ 2 │  ───→         │ 1 │
            │ 1 │              └───┘
            └───┘
```

---

## Call Stack for Functions

### Each Function Call Creates a Frame

A **frame** contains:
- Function name
- Parameters
- Local variables
- Return address

### Example: Simple Recursion

```java
void print(int n) {
    if (n == 0) return;           // 1. BASE CASE
    System.out.println(n);        // 2. WORK
    print(n - 1);                 // 3. RECURSIVE CALL
}

print(3);  // Start with 3
```

### Step-by-Step Execution

```
STEP 1: print(3) called
┌──────────────────┐
│ print(3)         │ ← Added to stack
└──────────────────┘

STEP 2: print(3) calls print(2)
┌──────────────────┐
│ print(2)         │ ← New frame added on top
├──────────────────┤
│ print(3)         │
└──────────────────┘

STEP 3: print(2) calls print(1)
┌──────────────────┐
│ print(1)         │ ← New frame added on top
├──────────────────┤
│ print(2)         │
├──────────────────┤
│ print(3)         │
└──────────────────┘

STEP 4: print(1) calls print(0)
┌──────────────────┐
│ print(0)         │ ← New frame added
├──────────────────┤
│ print(1)         │
├──────────────────┤
│ print(2)         │
├──────────────────┤
│ print(3)         │
└──────────────────┘

STEP 5: print(0) hits BASE CASE → returns
┌──────────────────┐
│ print(1)         │ ← print(0) removed
├──────────────────┤
│ print(2)         │
├──────────────────┤
│ print(3)         │
└──────────────────┘

STEP 6: print(1) finishes → returns
┌──────────────────┐
│ print(2)         │ ← print(1) removed
├──────────────────┤
│ print(3)         │
└──────────────────┘

STEP 7: print(2) finishes → returns
┌──────────────────┐
│ print(3)         │ ← print(2) removed
└──────────────────┘

STEP 8: print(3) finishes → returns
(Empty stack)
```

---

## Two Phases of Recursion

### Phase 1: FORWARD (Building Stack)
```
print(3)
  ↓ calls
print(2)
  ↓ calls
print(1)
  ↓ calls
print(0)
  ↓ BASE CASE
```
Stack grows: depth increases from 1 to 4

### Phase 2: BACKWARD (Unwinding Stack)
```
print(0) → BASE CASE, returns
print(1) ← receives return
print(2) ← receives return
print(3) ← receives return
```
Stack shrinks: depth decreases from 4 to 1

---

## Detailed Example: sum(4)

```java
int sum(int n) {
    if (n == 0) return 0;           // Base case
    return n + sum(n - 1);          // Recursive
}

sum(4);
```

### Execution Trace

```
CALL 1: sum(4)
  → n = 4, not 0
  → needs sum(3)
  → CALL 2
  
CALL 2: sum(3)
  → n = 3, not 0
  → needs sum(2)
  → CALL 3
  
CALL 3: sum(2)
  → n = 2, not 0
  → needs sum(1)
  → CALL 4
  
CALL 4: sum(1)
  → n = 1, not 0
  → needs sum(0)
  → CALL 5
  
CALL 5: sum(0)
  → n = 0, BASE CASE
  → return 0 ✓

UNWIND CALL 4: sum(1)
  → got 0 from sum(0)
  → return 1 + 0 = 1 ✓
  
UNWIND CALL 3: sum(2)
  → got 1 from sum(1)
  → return 2 + 1 = 3 ✓
  
UNWIND CALL 2: sum(3)
  → got 3 from sum(2)
  → return 3 + 3 = 6 ✓
  
UNWIND CALL 1: sum(4)
  → got 6 from sum(3)
  → return 4 + 6 = 10 ✓

FINAL RESULT: 10
```

### Stack Visualization

```
TIME:  0      1      2      3      4      5      6      7      8

       S(4)
       │
       ├─ S(3)
       │  │
       │  ├─ S(2)
       │  │  │
       │  │  ├─ S(1)
       │  │  │  │
       │  │  │  └─ S(0) ← PEAK (depth 5)
       │  │  │    ↓
       │  │  │    return 0
       │  │  │ ↙
       │  │  return 1
       │  │ ↙
       │  return 3
       │ ↙
       return 6
       ↓
       return 10 ← FINAL
```

---

## Memory Management

### Stack vs Heap
```
STACK (Function calls):
├─ sum(4) frame
├─ sum(3) frame
├─ sum(2) frame
├─ sum(1) frame
└─ sum(0) frame
│
└─ Size limit: ~1-8 MB

HEAP (Objects):
├─ Your data structures
└─ Can be much larger
```

### Each Frame Contains
```java
int sum(int n) {
    int x = 5;
    int y = 10;
    return x + y;
}

Frame for sum(5):
┌──────────────────┐
│ n = 5            │
│ x = 5            │
│ y = 10           │
│ return addr      │ ← Where to return after this call
└──────────────────┘
```

---

## Recursion Depth

### Maximum Recursion Depth

```java
int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

factorial(10);        // ✓ OK (depth 11)
factorial(100);       // ✓ OK (depth 101)
factorial(1000);      // ✓ OK (depth 1001)
factorial(10000);     // ✗ StackOverflowError (depth 10001)
factorial(100000);    // ✗ StackOverflowError
```

### Stack Size Limit
```
Java: Typically 1-8 MB
  → ~10,000 safe calls
  
Python: Typically 8 MB
  → ~1,000 safe calls
  
C++: Varies
  → Can go higher
```

---

## Recursion with Return Values

### Example: factorial(3)

```java
int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

factorial(3)
```

### Stack with Return Values

```
Call 1: factorial(3)
  ├─ Needs: 3 * factorial(2)
  
  Call 2: factorial(2)
    ├─ Needs: 2 * factorial(1)
    
    Call 3: factorial(1)
      └─ return 1 ✓
    
  ├─ Has result: 1
  ├─ Calculates: 2 * 1 = 2
  └─ return 2 ✓

├─ Has result: 2
├─ Calculates: 3 * 2 = 6
└─ return 6 ✓

FINAL: 6
```

---

## Print Order: Before vs After

### BEFORE Recursion (Decreasing)

```java
void printBefore(int n) {
    if (n == 0) return;
    System.out.println(n);      // Print BEFORE
    printBefore(n - 1);
}

printBefore(3);
```

```
Call 1: printBefore(3)
  → print "3"
  → call printBefore(2)
    Call 2: printBefore(2)
      → print "2"
      → call printBefore(1)
        Call 3: printBefore(1)
          → print "1"
          → call printBefore(0)
            Call 4: printBefore(0)
              → BASE CASE, return

OUTPUT: 3, 2, 1 (forward phase)
```

### AFTER Recursion (Increasing)

```java
void printAfter(int n) {
    if (n == 0) return;
    printAfter(n - 1);
    System.out.println(n);      // Print AFTER
}

printAfter(3);
```

```
Call 1: printAfter(3)
  → call printAfter(2)
    Call 2: printAfter(2)
      → call printAfter(1)
        Call 3: printAfter(1)
          → call printAfter(0)
            Call 4: printAfter(0)
              → BASE CASE, return
          ← Back: print "1"
        ← Back: print "2"
      ← Back: print "3"

OUTPUT: 1, 2, 3 (backward phase)
```

---

## Key Insights

### 1. Stack Depth = Recursion Depth
```
sum(5) has depth 6
sum(100) has depth 101
sum(n) has depth n+1
```

### 2. Maximum Depth is Limited
```
If max depth = 10,000
Then sum(10,000) works
But sum(10,001) crashes
```

### 3. Each Call Takes Memory
```
Per call: ~50-100 bytes
10,000 calls × 100 bytes = ~1 MB
100,000 calls × 100 bytes = ~10 MB (too much!)
```

### 4. Backward Phase is Crucial
```
Operations can happen during:
1. Forward phase (before recursion)
2. Backward phase (after recursion)

Choice matters for output order!
```

---

**Next:** Learn about Stack Overflow → `03_Stack_Overflow.md`
