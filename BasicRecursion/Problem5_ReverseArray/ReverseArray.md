# Problem 5: Reverse Array In-Place

## Problem Statement
Given an array **arr** of **n** elements, **reverse the array in-place** using recursion.

**In-place** means: Modify the original array, don't create a new one.

**Examples:**
- Input: [1, 2, 3, 4, 5] → Output: [5, 4, 3, 2, 1]
- Input: [1, 2, 1, 1, 5, 1] → Output: [1, 5, 1, 1, 2, 1]
- Input: [10] → Output: [10] (single element, no change)
- Input: [1, 2] → Output: [2, 1]

---

## Understanding the Problem

### What is In-Place Reversal?
```
Original array:
[1][2][3][4][5]
 0  1  2  3  4  (indices)

Goal: Reverse WITHOUT creating new array

Process:
- Swap arr[0] with arr[4]: [5][2][3][4][1]
- Swap arr[1] with arr[3]: [5][4][3][2][1]
- Stop (pointers crossed)

Result: [5][4][3][2][1] ✓
```

### Why Use Two Pointers?
- **Left pointer**: Starts at beginning (index 0)
- **Right pointer**: Starts at end (index n-1)
- **Swap**: Exchange elements at left and right
- **Move**: left++, right--
- **Stop**: When left >= right (pointers crossed or met)

### Visual

```
BEFORE:
[1][2][3][4][5]
 ↑              ↑
 L              R

SWAP:
[5][2][3][4][1]
 ↑              ↑
 L              R (after swap)

AFTER MOVE:
[5][2][3][4][1]
    ↑        ↑
    L        R

(Repeat until L >= R)
```

---

## Solution Explanation

### Complete Code
```java
public static void reverse(int[] arr, int n) {
    reverseHelper(arr, 0, n - 1);
}

private static void reverseHelper(int[] arr, int left, int right) {
    // BASE CASE
    if (left >= right) {
        return;
    }
    
    // SWAP
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    
    // RECURSIVE CALL
    reverseHelper(arr, left + 1, right - 1);
}
```

### The 3 Parts

#### Part 1: BASE CASE
```java
if (left >= right) {
    return;
}
```
- **What?** When pointers have crossed or met
- **Why?** Array is fully reversed
- **When?** After n/2 swaps

**Examples:**
```
Array size 5: [a][b][c][d][e]
- Start: left=0, right=4
- Step 1: left=1, right=3 (swapped 0,4)
- Step 2: left=2, right=2 (swapped 1,3)
- Stop: left==right (element at index 2 stays)

Array size 6: [a][b][c][d][e][f]
- Start: left=0, right=5
- Step 1: left=1, right=4 (swapped 0,5)
- Step 2: left=2, right=3 (swapped 1,4)
- Step 3: left=3, right=2 (swapped 2,3)
- Stop: left>right (pointers crossed)
```

#### Part 2: SWAP
```java
int temp = arr[left];
arr[left] = arr[right];
arr[right] = temp;
```
- **What?** Exchange two elements
- **Why?** Two-pointer technique for reversal
- **How?** Use temporary variable to avoid losing data

**Swap Visualization:**
```
Before:     arr[left]=5, arr[right]=1
            temp uninitialized

Step 1:     temp = 5
            arr[left] (was 5), now unassigned
            
Step 2:     arr[left] = 1
            arr[right] (was 1), now unassigned
            
Step 3:     arr[right] = 5
            
After:      arr[left]=1, arr[right]=5 ✓
```

#### Part 3: RECURSIVE CALL
```java
reverseHelper(arr, left + 1, right - 1);
```
- **What?** Call itself with pointers moved
- **Why?** Process remaining elements
- **Progress:** Pointers move toward each other

---

## Step-by-Step Example: [1, 2, 3, 4, 5]

### Forward Phase (Building Stack)

```
CALL 1: reverseHelper(arr, 0, 4)
  ├─ left=0, right=4
  ├─ 0 < 4, so continue
  ├─ SWAP: arr[0] ↔ arr[4]
  │         [1,2,3,4,5] → [5,2,3,4,1]
  └─ Call reverseHelper(arr, 1, 3)

CALL 2: reverseHelper(arr, 1, 3)
  ├─ left=1, right=3
  ├─ 1 < 3, so continue
  ├─ SWAP: arr[1] ↔ arr[3]
  │         [5,2,3,4,1] → [5,4,3,2,1]
  └─ Call reverseHelper(arr, 2, 2)

CALL 3: reverseHelper(arr, 2, 2)
  ├─ left=2, right=2
  ├─ 2 >= 2, BASE CASE!
  └─ return (no more swaps needed)
```

### Call Stack

```
PEAK STACK:
┌──────────────────────────────┐
│ reverseHelper(arr, 2, 2)     │ ← BASE CASE
│ reverseHelper(arr, 1, 3)     │
│ reverseHelper(arr, 0, 4)     │ ← Main call
└──────────────────────────────┘

Stack depth: 3 (which is n/2 + 1)
```

### Array Changes

```
Step 0: [1, 2, 3, 4, 5] (original)
         ↕              (swap 0 and 4)
Step 1: [5, 2, 3, 4, 1]
            ↕        (swap 1 and 3)
Step 2: [5, 4, 3, 2, 1] (reversed!)
               ↑
            (2 == 2, stop)
```

### Final Output
```
[5, 4, 3, 2, 1] ✓
```

---

## Complexity Analysis

### Time Complexity: O(n)

```
For array of size n:
- Swap at each level: O(1)
- Maximum levels: n/2 (until pointers meet)
- Total: (n/2) × O(1) = O(n) ✓

Example: n=6
Calls:      1,  2,  3,  0
Swaps: yes, yes, yes, no
Total: 3 swaps = n/2 ✓
```

**Breakdown:**
```
Call 1: left=0, right=5 (swap) → move to (1,4)
Call 2: left=1, right=4 (swap) → move to (2,3)
Call 3: left=2, right=3 (swap) → move to (3,2)
Call 4: left=3, right=2 (base case, return)

Total: 3 swaps = 6/2 ✓
```

### Space Complexity: O(n)

```
Call stack depth:

For n=5:
reverseHelper(arr, 0, 4)
  ├─ reverseHelper(arr, 1, 3)
  │   ├─ reverseHelper(arr, 2, 2)
  │       └─ BASE CASE

Depth: 3 = (5/2) + 1 ≈ O(n) ✓

For n=6:
reverseHelper(arr, 0, 5)
  ├─ reverseHelper(arr, 1, 4)
  │   ├─ reverseHelper(arr, 2, 3)
  │       ├─ reverseHelper(arr, 3, 2)
  │           └─ BASE CASE

Depth: 4 = (6/2) + 1 ≈ O(n) ✓

General: Depth = n/2 + 1 ≈ O(n)
```

---

## Alternative: Single-Pointer Approach

### Code
```java
private static void reverseSingleHelper(int[] arr, int i, int n) {
    // BASE CASE: reached middle
    if (i >= n / 2) {
        return;
    }
    
    // SWAP: element at i with element at (n-i-1)
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
    
    // RECURSIVE CALL
    reverseSingleHelper(arr, i + 1, n);
}

// Call: reverseSingleHelper(arr, 0, n)
```

### Comparison

| Aspect | Two-Pointer | Single-Pointer |
|--------|-------------|----------------|
| **Clarity** | Very clear | Less intuitive |
| **Logic** | left, right pointers | Calculate opposite |
| **Base Case** | left >= right | i >= n/2 |
| **Time** | O(n) | O(n) |
| **Space** | O(n) | O(n) |

---

## Alternative: Iterative Solution

### Code
```java
public static void reverseIterative(int[] arr) {
    int left = 0, right = arr.length - 1;
    
    while (left < right) {
        // SWAP
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
        // MOVE POINTERS
        left++;
        right--;
    }
}

// Time: O(n)
// Space: O(1) (no call stack!)
```

---

## Common Mistakes & Fixes

### ❌ Mistake 1: No Base Case
```java
// WRONG
private static void wrong(int[] arr, int left, int right) {
    // Swap
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    
    // Recursive call (no base case!)
    wrong(arr, left + 1, right - 1);
}

// Result: StackOverflowError ❌
```

**Fix:**
```java
// RIGHT
private static void correct(int[] arr, int left, int right) {
    if (left >= right) return;  // ✓ Base case
    
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    
    correct(arr, left + 1, right - 1);
}
```

### ❌ Mistake 2: Wrong Pointer Movement
```java
// WRONG
private static void wrong(int[] arr, int left, int right) {
    if (left >= right) return;
    
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    
    wrong(arr, left + 1, right);  // Only left moves!
}

// Result: Infinite loop or wrong reversal ❌
```

**Fix:**
```java
// RIGHT
private static void correct(int[] arr, int left, int right) {
    if (left >= right) return;
    
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    
    correct(arr, left + 1, right - 1);  // ✓ Both move
}
```

### ❌ Mistake 3: Off-by-One Error
```java
// WRONG
public static void reverse(int[] arr, int n) {
    reverseHelper(arr, 0, n);  // Should be n-1!
}

// Result: ArrayIndexOutOfBoundsException ❌
```

**Fix:**
```java
// RIGHT
public static void correct(int[] arr, int n) {
    reverseHelper(arr, 0, n - 1);  // ✓ Correct
}
```

### ❌ Mistake 4: Not Swapping (Just Recursing)
```java
// WRONG
private static void wrong(int[] arr, int left, int right) {
    if (left >= right) return;
    // No swap! Just recurse
    wrong(arr, left + 1, right - 1);
}

// Result: Array unchanged ❌
```

**Fix:**
```java
// RIGHT
private static void correct(int[] arr, int left, int right) {
    if (left >= right) return;
    
    // SWAP first
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    
    correct(arr, left + 1, right - 1);  // Then recurse
}
```

---

## Test Cases

### Test 1: Basic Array
```java
int[] arr1 = {1, 2, 3, 4, 5};
reverse(arr1, 5);
// Result: [5, 4, 3, 2, 1] ✓
```

### Test 2: Even Length
```java
int[] arr2 = {1, 2, 3, 4};
reverse(arr2, 4);
// Result: [4, 3, 2, 1] ✓
```

### Test 3: Mixed Values
```java
int[] arr3 = {1, 2, 1, 1, 5, 1};
reverse(arr3, 6);
// Result: [1, 5, 1, 1, 2, 1] ✓
```

### Test 4: Single Element
```java
int[] arr4 = {10};
reverse(arr4, 1);
// Result: [10] ✓ (no change)
```

### Test 5: Two Elements
```java
int[] arr5 = {1, 2};
reverse(arr5, 2);
// Result: [2, 1] ✓
```

### Test 6: Large Array
```java
int[] arr6 = new int[1000];
for (int i = 0; i < 1000; i++) arr6[i] = i;
reverse(arr6, 1000);
// Result: [999, 998, ..., 1, 0] ✓
```

---

## Key Patterns Learned

### Pattern: Two-Pointer Recursion
```
Used for:
- Array reversal ✓
- Palindrome checking
- Two-sum problems
- Container with most water

Template:
private static void twoPointerRecursion(Type[] arr, int left, int right) {
    if (left >= right) return;
    
    // Do work at left and right
    
    twoPointerRecursion(arr, left + 1, right - 1);
}
```

---

## Key Takeaways

✅ **What We Learned:**
1. Two-pointer technique for array problems
2. In-place modification concept
3. Swap mechanism using temporary variable
4. Base case: when pointers meet/cross
5. O(n) time, O(n) space for recursion

✅ **When to Use:**
- Reverse arrays
- Check palindromes
- Compare elements from ends
- Two-pointer problems in general

✅ **Alternatives:**
- Iterative: Better (O(1) space)
- Collections.reverse(): Best for production
- Two single-pointer loops

---

## Summary

| Aspect | Details |
|--------|---------|
| **Problem** | Reverse array in-place |
| **Approach** | Two-pointer recursion |
| **Base Case** | left >= right |
| **Work** | Swap arr[left] and arr[right] |
| **Recursive** | reverseHelper(arr, left+1, right-1) |
| **Time** | O(n) |
| **Space** | O(n) |
| **Difficulty** | ⭐⭐⭐ Medium |

---

**Next Problem:** Palindrome Check → Problem6_PalindromeCheck
