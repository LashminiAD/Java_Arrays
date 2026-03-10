# Two Sum (#1 LeetCode)

## Problem

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

---

## Example

**Input**

nums = [2,7,11,15]  
target = 9

**Output**

[0,1]

---

## Explanation

nums[0] = 2  
nums[1] = 7  
2 + 7 = 9  

So we return indices **[0, 1]**.

---
# Two Sum – LeetCode #1

## Problem
Given an array of integers `nums` and an integer `target`, return the **indices of the two numbers** such that they add up to the target.

You may assume that each input would have **exactly one solution**, and you **may not use the same element twice**.

---

## Example

### Input
```
nums = [2,7,11,15]
target = 9
```

### Output
```
[0,1]
```

### Explanation
```
nums[0] = 2
nums[1] = 7

2 + 7 = 9
```

So we return the indices `[0,1]`.

---

# Approach 1: Brute Force

## Idea
1. Pick the first element.
2. Compare it with every other element.
3. Check if their sum equals the target.
4. If yes → return the indices.

### Time Complexity
```
O(n²)
```

### Space Complexity
```
O(1)
```

---

# Approach 2: Optimized using HashMap

## HashMap Concept

A **HashMap** stores data in **key-value pairs**.

```
Key   → Value
Number → Index
```

Example:

```
2 → 0
7 → 1
11 → 2
15 → 3
```

This allows **fast lookup in O(1) time**.

---

## Optimized Idea

Instead of checking every pair, we calculate the **complement**.

```
complement = target - current number
```

Then we check:

```
Does this complement already exist in the HashMap?
```

If **yes**, we found the pair.

---

## Step-by-Step Example

```
nums = [2,7,11,15]
target = 9
```

### Step 1
```
i = 0
nums[i] = 2
complement = 9 - 2 = 7
```

HashMap does not contain `7`.

So store:

```
2 → 0
```

---

### Step 2
```
i = 1
nums[i] = 7
complement = 9 - 7 = 2
```

HashMap **contains 2**.

```
2 → 0
```

So the answer is:

```
[0,1]
```

---

# Complexity Analysis

## Brute Force
```
Time Complexity  : O(n²)
Space Complexity : O(1)
```

## Optimized (HashMap)
```
Time Complexity  : O(n)
Space Complexity : O(n)
```

---

# Key Learning

✔ Understanding **Brute Force first helps build problem-solving intuition.**

✔ **HashMap reduces time complexity from O(n²) to O(n).**

✔ This problem teaches an important interview technique:

> **Using a HashMap to store previously seen elements for faster lookup.**

---
